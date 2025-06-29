package thkoeln.archilab.st2.a2.motorclub.domain;

import jakarta.persistence.Converter;
import thkoeln.archilab.st2.GenericIdConverter;

@Converter(autoApply = true)
public class MotorClubIdConverter extends GenericIdConverter<MotorClubId> {
    public MotorClubIdConverter() {
        super( MotorClubId::new );
    }
}
