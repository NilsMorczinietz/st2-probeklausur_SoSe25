package thkoeln.archilab.st2.a6.doctor.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDTO {
    private UUID id;
    private String name;
    private String specialization;
}
