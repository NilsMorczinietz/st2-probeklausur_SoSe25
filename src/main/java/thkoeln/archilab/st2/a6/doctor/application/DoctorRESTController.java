package thkoeln.archilab.st2.a6.doctor.application;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorRESTController {

    private final DoctorApplicationService doctorApplicationService;


    @Autowired
    public DoctorRESTController( DoctorApplicationService doctorApplicationService ) {
        this.doctorApplicationService = doctorApplicationService;
    }

    // Reminder: Es müssen nur die ersten beiden Anforderungen implementiert werden, alle anderen nicht!
    // TODO implement (1) Daten eines `Doctors` abfragen (ohne Ausgabe der `AppointmentSlots`)


    // TODO implement (2) Spezialisierung (`specialization`) eines `Doctor` ändern


}
