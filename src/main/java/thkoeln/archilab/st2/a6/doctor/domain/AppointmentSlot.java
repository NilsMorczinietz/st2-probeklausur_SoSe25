package thkoeln.archilab.st2.a6.doctor.domain;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private Integer hourNumber;
    private String patientName;

    public AppointmentSlot( String date, Integer hourNumber ) {
        this.date = date;
        this.hourNumber = hourNumber;
        this.patientName = "undefined";
    }
}
