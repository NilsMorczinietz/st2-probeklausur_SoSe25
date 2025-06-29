package thkoeln.archilab.st2.a1;

import jakarta.persistence.Converter;
import thkoeln.archilab.st2.GenericIdConverter;

@Converter(autoApply = true)
public class LegalClauseIdConverter extends GenericIdConverter<LegalClauseId> {
    public LegalClauseIdConverter() {
        super( LegalClauseId::new );
    }
}
