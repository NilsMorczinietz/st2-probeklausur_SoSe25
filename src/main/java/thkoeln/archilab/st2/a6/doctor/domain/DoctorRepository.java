package thkoeln.archilab.st2.a6.doctor.domain;


import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface DoctorRepository extends CrudRepository<Doctor, UUID> {
}
