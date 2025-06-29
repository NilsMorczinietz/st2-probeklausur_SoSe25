package thkoeln.archilab.st2.a4.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface MedicalCareCenterRepository extends CrudRepository<MedicalCareCenter, MedicalCareCenterId> {
}
