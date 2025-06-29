package thkoeln.archilab.st2.a3.course.domain;

import jakarta.persistence.Converter;
import thkoeln.archilab.st2.GenericIdConverter;

@Converter(autoApply = true)
public class CourseIdConverter extends GenericIdConverter<CourseId> {
    public CourseIdConverter() {
        super( CourseId::new );
    }
}
