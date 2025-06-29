package thkoeln.archilab.st2.a6.doctor.domain;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import thkoeln.archilab.st2.GenericId;

import java.util.UUID;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AttributeOverride(name = "id", column = @Column(name = "appointmentslot_id"))
public class AppointmentSlotId extends GenericId {
    public AppointmentSlotId( UUID id ) {
        super( id );
    }
}
