package thkoeln.archilab.st2.a7.domain;

import jakarta.persistence.Converter;
import thkoeln.archilab.st2.GenericIdConverter;

@Converter(autoApply = true)
public class ShipmentIdConverter extends GenericIdConverter<ShipmentId> {
    public ShipmentIdConverter() {
        super( ShipmentId::new );
    }
}
