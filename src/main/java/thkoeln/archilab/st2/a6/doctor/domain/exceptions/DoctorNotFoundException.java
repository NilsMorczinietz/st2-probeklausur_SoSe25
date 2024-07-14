package thkoeln.archilab.st2.a6.doctor.domain.exceptions;


public class DoctorNotFoundException extends RuntimeException {
    public DoctorNotFoundException(String message) {
        super(message);
    }
}
