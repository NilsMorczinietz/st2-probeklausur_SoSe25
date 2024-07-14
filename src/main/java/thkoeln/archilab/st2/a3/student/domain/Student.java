package thkoeln.archilab.st2.a3.student.domain;

import lombok.*;
import thkoeln.archilab.st2.a3.domainprimitives.ImmatriculationNumber;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter @Setter
@NoArgsConstructor( access = AccessLevel.PROTECTED )
@EqualsAndHashCode( of = {"id"} )
public class Student {
    @Id @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;
    private ImmatriculationNumber immatriculationNumber;


    public Student( String name, ImmatriculationNumber immatriculationNumber ) {
        if ( name == null || name.isEmpty() || immatriculationNumber == null )
            throw new IllegalArgumentException( "Name or immatriculation number invalid" );
        this.name = name;
        this.immatriculationNumber = immatriculationNumber;
    }
}
