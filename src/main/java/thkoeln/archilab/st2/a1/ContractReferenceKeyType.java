package thkoeln.archilab.st2.a1;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import thkoeln.archilab.st2.GenericId;

import java.util.UUID;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AttributeOverride(name = "id", column = @Column(name = "contract_id"))
public class ContractReferenceKeyType extends GenericId {
    public ContractReferenceKeyType( UUID id ) {
        super( id );
    }
}
