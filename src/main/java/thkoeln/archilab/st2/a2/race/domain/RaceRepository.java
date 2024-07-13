package thkoeln.archilab.st2.a2.race.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RaceRepository extends CrudRepository<Race, UUID> {
}
