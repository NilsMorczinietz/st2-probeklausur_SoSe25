package thkoeln.archilab.st2.a1;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

/**
 * A customer of our company, who can sign contracts with us.
 */
@Entity
@Getter @Setter
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.PRIVATE)
    private UUID id;

    private String name;
    // ... we skip the other properties

    //  ... we also skip the business logic
}
