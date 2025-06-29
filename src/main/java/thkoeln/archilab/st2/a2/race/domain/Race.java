package thkoeln.archilab.st2.a2.race.domain;

import lombok.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter @Setter
@NoArgsConstructor( access = AccessLevel.PROTECTED )
@EqualsAndHashCode( of = {"id"} )
public class Race {
    @Id @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    // the name of the track for that race
    private String tname;

    // the date
    private LocalDate raceDay;

    public Race( String tname, LocalDate raceDay ) {
        this.tname = tname;
        this.raceDay = raceDay;
    }

}
