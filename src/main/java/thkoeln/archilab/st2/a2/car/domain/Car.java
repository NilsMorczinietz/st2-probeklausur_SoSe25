package thkoeln.archilab.st2.a2.car.domain;

import jakarta.persistence.*;
import lombok.*;
import thkoeln.archilab.st2.a2.race.domain.Race;
import thkoeln.archilab.st2.a2.race.domain.RaceId;

import java.util.ArrayList;
import java.util.List;

/**
 * A semiprofessional or professional athlete
 */

@Entity
@Getter @Setter
@NoArgsConstructor( access = AccessLevel.PROTECTED )
@EqualsAndHashCode( of = {"id"} )
public class Car {
    @EmbeddedId
    @Setter(AccessLevel.PRIVATE)    // only for JPA
    private CarId id;

    // brand (Marke) and type of the car
    private String b;
    private String t;

    // the registration number of the car
    private Integer registrationNumber;

    public Car( String b, String t, Integer registrationNumber ) {
        this.b = b;
        this.t = t;
        this.registrationNumber = registrationNumber;
        this.id = new CarId();
    }

    // the races in which this car has participated or will participate in the future
    @ElementCollection( fetch = FetchType.EAGER )
    private final List<RaceId> theRacesInWhichThisCarHasParticipatedOrWillParticipateInTheFuture = new ArrayList<>();
}
