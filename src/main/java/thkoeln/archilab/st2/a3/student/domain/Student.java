package thkoeln.archilab.st2.a3.student.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import thkoeln.archilab.st2.a3.course.domain.Course;
import thkoeln.archilab.st2.a3.studyprogram.domain.StudyProgram;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.PRIVATE)
    private UUID id;

    private String name;
    private Integer matriculationNumber;
    private Integer averageGrade;

    private UUID studyProgramId;

    public Student( String name, Integer matriculationNumber, StudyProgram studyProgram ) {
        this.name = name;
        this.matriculationNumber = matriculationNumber;
        this.studyProgramId = studyProgram.getId();
        this.averageGrade = 0;
    }


    /**
     * @param course
     * @return The ranking of the student in the course. If the student is not enrolled in the course, 0 is returned.
     */
    public int rankingIn( Course course ) {
        List<Student> students = course.enrolledStudents();
        if ( !students.contains( this ) ) return 0;
        // Sort the list of students by scorePoints in descending order
        students.sort( Comparator.comparing(Student::getAverageGrade ).reversed());
        // Find the index of this student in the sorted list - that is the ranking
        return students.indexOf( this ) + 1;
    }


    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( !( o instanceof Student ) ) return false;
        Student student = (Student) o;
        return getId().equals( student.getId() );
    }

    @Override
    public int hashCode() {
        return Objects.hash( getId() );
    }
}
