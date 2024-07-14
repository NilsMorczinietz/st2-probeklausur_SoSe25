package thkoeln.archilab.st2.a6.doctor.domain;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import thkoeln.archilab.st2.a6.doctor.domain.exceptions.DoctorCreateException;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Doctor {
    @Id
    @Setter(AccessLevel.PROTECTED)
    private UUID id;

    private String name;
    private String specialization;

    @OneToMany(cascade = CascadeType.ALL)
    @Setter(AccessLevel.PROTECTED)
    private List<AppointmentSlot> appointmentSlots = new ArrayList<>();

    public Doctor( UUID id, String name, String specialization ) {
        if ( id == null || name == null || specialization == null )
            throw new DoctorCreateException( "Invalid parameters!" );
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

}
