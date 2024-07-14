package thkoeln.archilab.st2.a3.course.domain;

import lombok.*;
import thkoeln.archilab.st2.a3.student.domain.Student;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter @Setter
@NoArgsConstructor( access = AccessLevel.PROTECTED )
@EqualsAndHashCode( of = {"id"} )
public class Course {
    @Id @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    // the name of the course
    private String name;

    // the ects points of the course
    private Integer ects;

    // the enrolled students
    @ManyToMany( fetch = FetchType.EAGER )
    private final List<Student> enrolledStudents = new ArrayList<>();


    public Course( String name, Integer ects ) {
        this.name = name;
        this.ects = ects;
    }


    public void enrollStudent( Student student ) {
        if ( student == null ) throw new IllegalArgumentException( "Student is null" );
        enrolledStudents.add( student );
    }


    /**
     * @return The average semester number of the enrolled students, for statistical
     *         purposes.
     */
    public Float averageSemesterNumber() {
        Float sum = 0f;
        for ( Student student : enrolledStudents )
            sum += student.getImmatriculationNumber().currentSemesterNumber();
        return sum / Float.valueOf( enrolledStudents.size() );
    }
}
