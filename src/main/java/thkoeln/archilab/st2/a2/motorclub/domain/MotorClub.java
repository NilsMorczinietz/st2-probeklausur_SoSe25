package thkoeln.archilab.st2.a2.motorclub.domain;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@EqualsAndHashCode( of = {"id"} )
public class MotorClub {
    @EmbeddedId
    @Setter(AccessLevel.PRIVATE)    // only for JPA
    private MotorClubId id;

    // MotorClub name
    private String name;

    public MotorClub() {
        this.id = new MotorClubId();
    }
}
