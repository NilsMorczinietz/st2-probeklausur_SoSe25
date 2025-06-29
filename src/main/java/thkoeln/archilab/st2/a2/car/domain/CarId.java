package thkoeln.archilab.st2.a2.car.domain;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import thkoeln.archilab.st2.GenericId;

import java.util.UUID;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AttributeOverride(name = "id", column = @Column(name = "car_id"))
public class CarId extends GenericId {
    public CarId( UUID id ) {
        super( id );
    }
}
