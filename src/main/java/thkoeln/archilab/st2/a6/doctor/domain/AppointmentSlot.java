package thkoeln.archilab.st2.a6.doctor.domain;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AppointmentSlot {
    @EmbeddedId
    @Setter(AccessLevel.PRIVATE)    // only for JPA
    private AppointmentSlotId id;

    private String date;
    private Integer hourNumber;
    private String patientName;

    public AppointmentSlot( String date, Integer hourNumber ) {
        this.date = date;
        this.hourNumber = hourNumber;
        this.patientName = "undefined";
        this.id = new AppointmentSlotId();
    }
}
