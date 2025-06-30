package thkoeln.archilab.st2.a1.domainprimitives;

import lombok.*;

import jakarta.persistence.Embeddable;

/**
 * A reference to a paragraph in a specific law, for use in a legal clause in one of
 * our contracts.
 */
@Embeddable
@Getter
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor( access = AccessLevel.PROTECTED )
public class LegalReference {
    private String lawName;
    private Integer paragraph;
    // ... we skip the other properties
    //  ... we also skip the business logic
}
