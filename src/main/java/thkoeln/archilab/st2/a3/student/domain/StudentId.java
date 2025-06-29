package thkoeln.archilab.st2.a3.student.domain;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import thkoeln.archilab.st2.GenericId;

import java.util.UUID;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AttributeOverride(name = "id", column = @Column(name = "student_id"))
public class StudentId extends GenericId {
    public StudentId( UUID id ) {
        super( id );
    }
}
