package thkoeln.archilab.st2.a3.student.domain;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.*;
import thkoeln.archilab.st2.a3.domainprimitives.ImmatriculationNumber;

@Entity
@Getter @Setter
@NoArgsConstructor( access = AccessLevel.PROTECTED )
@EqualsAndHashCode( of = {"id"} )
public class Student {
    @EmbeddedId
    @Setter(AccessLevel.PRIVATE)    // only for JPA
    private StudentId id;

    private String name;

    @Embedded
    private ImmatriculationNumber immatriculationNumber;


    public Student( String name, ImmatriculationNumber immatriculationNumber ) {
        if ( name == null || name.isEmpty() || immatriculationNumber == null )
            throw new IllegalArgumentException( "Name or immatriculation number invalid" );
        this.name = name;
        this.immatriculationNumber = immatriculationNumber;
        this.id = new StudentId();
    }
}
