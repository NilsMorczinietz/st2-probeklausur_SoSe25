package thkoeln.archilab.st2.a6.doctor.domain;

import jakarta.persistence.Converter;
import thkoeln.archilab.st2.GenericIdConverter;

@Converter(autoApply = true)
public class AppointmentSlotIdConverter extends GenericIdConverter<AppointmentSlotId> {
    public AppointmentSlotIdConverter() {
        super( AppointmentSlotId::new );
    }
}
