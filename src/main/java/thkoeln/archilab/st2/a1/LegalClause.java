package thkoeln.archilab.st2.a1;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

/**
 * A clause in a contract that specifies specific aspects of the agreement
 * between our company and a customer.
 */
@Entity
@Getter
@Setter
public class LegalClause {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.PRIVATE)
    private UUID id;

    private String clauseText;
    // ... we skip the other properties

    @ElementCollection (fetch = FetchType.EAGER)
    private List<LegalReference> legalReferences;

    //  ... we also skip the business logic
}
