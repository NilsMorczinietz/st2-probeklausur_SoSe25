package thkoeln.archilab.st2.a1;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

/**
 * A legal agreement between our company and a customerEntity, where we (as the company) agree to
 * provide a service or product, and the customerEntity agrees to pay for it.
 */
@Entity
@Getter
@Setter
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.PRIVATE)
    private UUID id;

    private String title;
    private String purpose;
    // ... we skip the other properties

    @ManyToOne
    private CustomerEntity customerEntity;

    @OneToMany(cascade = CascadeType.ALL)
    private List<LegalClause> legalClauses;

    //  ... we also skip the business logic
}
