package thkoeln.archilab.st2.a3.student.domain;

import jakarta.persistence.Converter;
import thkoeln.archilab.st2.GenericIdConverter;

@Converter(autoApply = true)
public class StudentIdConverter extends GenericIdConverter<StudentId> {
    public StudentIdConverter() {
        super( StudentId::new );
    }
}
