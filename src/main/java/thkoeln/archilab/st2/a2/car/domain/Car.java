package thkoeln.archilab.st2.a2.car.domain;

import lombok.*;
import thkoeln.archilab.st2.a2.race.domain.Race;

import jakarta.persistence.*;
import java.util.*;

/**
 * A semiprofessional or professional athlete
 */

@Entity
@Getter @Setter
@NoArgsConstructor( access = AccessLevel.PROTECTED )
@EqualsAndHashCode( of = {"id"} )
public class Car {
    @Id @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    // brand (Marke) and type of the car
    private String b;
    private String t;

    // the registration number of the car
    private Integer registrationNumber;

    public Car( String b, String t, Integer registrationNumber ) {
        this.b = b;
        this.t = t;
        this.registrationNumber = registrationNumber;
    }

    // the races in which this car has participated or will participate in the future
    @ManyToMany( fetch = FetchType.EAGER )
    private final List<Race> theRacesInWhichThisCarHasParticipatedOrWillParticipateInTheFuture = new ArrayList<>();
}
