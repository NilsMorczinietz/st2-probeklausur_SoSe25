package thkoeln.archilab.st2.a2.race.domain;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter @Setter
@NoArgsConstructor( access = AccessLevel.PROTECTED )
@EqualsAndHashCode( of = {"id"} )
public class Race {
    @EmbeddedId
    @Setter(AccessLevel.PRIVATE)    // only for JPA
    private RaceId id;

    // the name of the track for that race
    private String tname;

    // the date
    private LocalDate raceDay;

    public Race( String tname, LocalDate raceDay ) {
        this.tname = tname;
        this.raceDay = raceDay;
        this.id = new RaceId();
    }

}
