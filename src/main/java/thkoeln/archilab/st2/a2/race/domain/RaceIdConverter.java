package thkoeln.archilab.st2.a2.race.domain;

import jakarta.persistence.Converter;
import thkoeln.archilab.st2.GenericIdConverter;

@Converter(autoApply = true)
public class RaceIdConverter extends GenericIdConverter<RaceId> {
    public RaceIdConverter() {
        super( RaceId::new );
    }
}
