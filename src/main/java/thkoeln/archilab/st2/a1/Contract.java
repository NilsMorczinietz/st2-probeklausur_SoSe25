package thkoeln.archilab.st2.a1;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * A legal agreement between our company and a customerEntity, where we (as the company) agree to
 * provide a service or product, and the customerEntity agrees to pay for it.
 */
@Entity
@Getter @Setter
public class Contract {
    @EmbeddedId
    @Setter(AccessLevel.PRIVATE)    // only for JPA
    private ContractReferenceKeyType id;

    private String title;
    private String purpose;
    // ... we skip the other properties

    @Embedded
    private CustomerId customerId;

    @OneToMany(cascade = CascadeType.ALL)
    private List<LegalClause> legalClauses;

    public Contract() {
        this.id = new ContractReferenceKeyType();
    }

    //  ... we also skip the business logic
}
