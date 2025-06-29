package thkoeln.archilab.st2.a4.domain;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import thkoeln.archilab.st2.GenericId;

import java.util.UUID;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AttributeOverride(name = "id", column = @Column(name = "medicalcarecenter_id"))
public class MedicalCareCenterId extends GenericId {
    public MedicalCareCenterId( UUID id ) {
        super( id );
    }
}
