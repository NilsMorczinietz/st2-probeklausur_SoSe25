package thkoeln.archilab.st2.a6.doctor.domain;

import jakarta.persistence.Converter;
import thkoeln.archilab.st2.GenericIdConverter;

@Converter(autoApply = true)
public class DoctorIdConverter extends GenericIdConverter<DoctorId> {
    public DoctorIdConverter() {
        super( DoctorId::new );
    }
}
