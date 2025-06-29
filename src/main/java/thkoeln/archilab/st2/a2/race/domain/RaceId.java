package thkoeln.archilab.st2.a2.race.domain;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import thkoeln.archilab.st2.GenericId;

import java.util.UUID;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AttributeOverride(name = "id", column = @Column(name = "race_id"))
public class RaceId extends GenericId {
    public RaceId( UUID id ) {
        super( id );
    }
}
