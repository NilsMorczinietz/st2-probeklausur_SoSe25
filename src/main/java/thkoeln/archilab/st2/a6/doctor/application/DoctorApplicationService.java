package thkoeln.archilab.st2.a6.doctor.application;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import thkoeln.archilab.st2.a6.doctor.domain.Doctor;
import thkoeln.archilab.st2.a6.doctor.domain.DoctorRepository;
import thkoeln.archilab.st2.a6.doctor.domain.exceptions.DoctorCreateException;
import thkoeln.archilab.st2.a6.doctor.domain.exceptions.DoctorNotFoundException;

import java.util.UUID;


@Component
public class DoctorApplicationService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorApplicationService( DoctorRepository doctorRepository ) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor findById( UUID id ) {
        if ( id == null ) throw new DoctorNotFoundException( "Id must not be null." );
        return doctorRepository.findById( id ).orElseThrow(
                () -> new DoctorNotFoundException( "Lawyer with id " + id + " not found." )
        );
    }

    public void save( Doctor doctor ) {
        if ( doctor == null ) throw new DoctorCreateException( "Lawyer must not be null." );
        doctorRepository.save( doctor );
    }


}
