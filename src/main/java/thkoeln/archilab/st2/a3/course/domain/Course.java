package thkoeln.archilab.st2.a3.course.domain;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import lombok.*;
import thkoeln.archilab.st2.a3.student.domain.Courseable;
import thkoeln.archilab.st2.a3.student.domain.Student;
import thkoeln.archilab.st2.a3.student.domain.StudentId;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = {"id"})
public class Course extends Courseable {

    @EmbeddedId
    @Setter(AccessLevel.PRIVATE)    // only for JPA
    private CourseId id;

    public void setId(UUID id){
        this.id = new CourseId(id);
    }
    public void setId(CourseId id){
        this.id = id;
    }

    // the name of the course
    private String name;

    // the ects points of the course
    private Integer ects;

    // the enrolled students
    @ElementCollection(fetch = FetchType.EAGER)
    private final List<StudentId> enrolledStudents = new ArrayList<>();


    public Course(String name, Integer ects) {
        this.name = name;
        this.ects = ects;
        this.id = new CourseId();
    }

    public void enrollStudent(Student student) {
        if (student == null) throw new IllegalArgumentException("Student is null");
        enrolledStudents.add(student.getId());
    }


}
