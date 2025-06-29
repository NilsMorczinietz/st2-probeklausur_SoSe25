package thkoeln.archilab.st2.a1;

import jakarta.persistence.Converter;
import thkoeln.archilab.st2.GenericIdConverter;

@Converter(autoApply = true)
public class ContractIdConverter extends GenericIdConverter<ContractReferenceKeyType> {
    public ContractIdConverter() {
        super( ContractReferenceKeyType::new );
    }
}
