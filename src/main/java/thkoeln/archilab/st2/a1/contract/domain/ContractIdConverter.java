package thkoeln.archilab.st2.a1.contract.domain;

import jakarta.persistence.Converter;
import thkoeln.archilab.st2.GenericIdConverter;

@Converter(autoApply = true)
public class ContractIdConverter extends GenericIdConverter<ContractId> {
    public ContractIdConverter() {
        super( ContractId::new );
    }
}
