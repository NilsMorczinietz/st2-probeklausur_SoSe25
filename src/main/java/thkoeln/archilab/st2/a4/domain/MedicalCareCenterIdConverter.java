package thkoeln.archilab.st2.a4.domain;

import jakarta.persistence.Converter;
import thkoeln.archilab.st2.GenericIdConverter;

@Converter(autoApply = true)
public class MedicalCareCenterIdConverter extends GenericIdConverter<MedicalCareCenterId> {
    public MedicalCareCenterIdConverter() {
        super( MedicalCareCenterId::new );
    }
}
