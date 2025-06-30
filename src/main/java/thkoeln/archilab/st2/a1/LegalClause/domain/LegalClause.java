package thkoeln.archilab.st2.a1.LegalClause.domain;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import thkoeln.archilab.st2.a1.domainprimitives.LegalReference;

import java.util.List;

/**
 * A clause in a contract that specifies specific aspects of the agreement
 * between our company and a customer.
 */
@Entity
@Getter
@Setter
public class LegalClause {
    @EmbeddedId
    @Setter(AccessLevel.PRIVATE)    // only for JPA
    private LegalClauseId id;

    private String clauseText;
    // ... we skip the other properties

    @ElementCollection (fetch = FetchType.EAGER)
    private List<LegalReference> legalReferences;

    public LegalClause() {
        this.id = new LegalClauseId();
    }

    //  ... we also skip the business logic
}
