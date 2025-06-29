package thkoeln.archilab.st2.a2.motorclub.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface MotorClubRepository extends CrudRepository<MotorClub, MotorClubId> {
}
