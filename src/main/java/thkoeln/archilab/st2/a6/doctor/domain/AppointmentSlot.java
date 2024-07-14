package thkoeln.archilab.st2.a6.doctor.domain;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AppointmentSlot {
    @Id
    @Setter(AccessLevel.PROTECTED)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String date;
    private Integer hour;
    private String patientName;

    public AppointmentSlot( String date, Integer hour ) {
        this.date = date;
        this.hour = hour;
        this.patientName = "undefined";
    }
}
