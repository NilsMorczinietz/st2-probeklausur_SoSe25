package thkoeln.archilab.st2.a6.doctor.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY, reason = "DemoNotFoundException") //422
public class DoctorCreateException extends RuntimeException {
    public DoctorCreateException( String message) {
        super(message);
    }
}
