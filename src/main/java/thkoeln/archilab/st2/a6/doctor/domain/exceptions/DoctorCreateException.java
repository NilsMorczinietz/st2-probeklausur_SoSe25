package thkoeln.archilab.st2.a6.doctor.domain.exceptions;


public class DoctorCreateException extends RuntimeException {
    public DoctorCreateException( String message) {
        super(message);
    }
}
