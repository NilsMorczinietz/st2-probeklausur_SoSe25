package thkoeln.archilab.st2.a3.student.domain;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import thkoeln.archilab.st2.a3.course.domain.CourseId;

@Entity
@Setter
@Getter
public abstract class Courseable {
    @EmbeddedId
    @Setter(AccessLevel.PRIVATE)    // only for JPA
    private CourseId id;

    // the ects points of the course
    private Integer ects;
}
