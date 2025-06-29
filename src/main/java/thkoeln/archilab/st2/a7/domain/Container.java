package thkoeln.archilab.st2.a7.domain;

import jakarta.persistence.Embeddable;
import lombok.*;

/**
 * Domain primitive for a shipment container.
 */
@Embeddable
@Getter
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Container {
    private Float length, width, height;
}
