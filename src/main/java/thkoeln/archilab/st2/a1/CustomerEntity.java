package thkoeln.archilab.st2.a1;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * A customer of our company, who can sign contracts with us.
 */
@Entity
@Getter @Setter
public class CustomerEntity {
    @EmbeddedId
    @Setter(AccessLevel.PRIVATE)    // only for JPA
    private CustomerId id;

    private String name;
    // ... we skip the other properties

    public CustomerEntity() {
        this.id = new CustomerId();
    }

    //  ... we also skip the business logic
}
