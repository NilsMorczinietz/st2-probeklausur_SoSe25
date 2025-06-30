package thkoeln.archilab.st2.a1.Contract.domain;

import jakarta.persistence.Converter;
import thkoeln.archilab.st2.GenericIdConverter;
import thkoeln.archilab.st2.a1.domainprimitives.ContractReferenceKeyType;

@Converter(autoApply = true)
public class ContractIdConverter extends GenericIdConverter<ContractReferenceKeyType> {
    public ContractIdConverter() {
        super( ContractReferenceKeyType::new );
    }
}
