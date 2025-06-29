package thkoeln.archilab.st2.a2.car.domain;

import jakarta.persistence.Converter;
import thkoeln.archilab.st2.GenericIdConverter;

@Converter(autoApply = true)
public class CarIdConverter extends GenericIdConverter<CarId> {
    public CarIdConverter() {
        super( CarId::new );
    }
}
