package thkoeln.archilab.st2.a1.Customer.domain;

import jakarta.persistence.Converter;
import thkoeln.archilab.st2.GenericIdConverter;

@Converter(autoApply = true)
public class CustomerIdConverter extends GenericIdConverter<CustomerId> {
    public CustomerIdConverter() {
        super( CustomerId::new );
    }
}
