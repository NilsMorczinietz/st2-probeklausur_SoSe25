package thkoeln.archilab.st2.a3.student.domain;

import lombok.*;
import thkoeln.archilab.st2.a3.domainprimitives.ImmatriculationNumber;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
