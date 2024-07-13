package thkoeln.archilab.st2.a2.race.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
