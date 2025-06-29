package thkoeln.archilab.st2.a7.domain;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import thkoeln.archilab.st2.a6.doctor.domain.AppointmentSlot;
import thkoeln.archilab.st2.a6.doctor.domain.DoctorId;
import thkoeln.archilab.st2.a6.doctor.domain.exceptions.DoctorCreateException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Shipment {
    @EmbeddedId
    @Setter(AccessLevel.PRIVATE)    // only for JPA
    private ShipmentId id;

    private String customerName;
    private boolean withinEU;

    @ElementCollection( fetch = FetchType.EAGER )
    private List<Container> containers = new ArrayList<>();

    public Shipment( String customerName, boolean withinEU ) {
        if ( customerName == null || customerName.isEmpty() ) throw new ShipmentException( "Invalid parameters!" );
        this.id = new ShipmentId();
        this.customerName = customerName;
        this.withinEU = withinEU;
    }

}
