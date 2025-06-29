package thkoeln.archilab.st2.a2.car.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CarRepository extends CrudRepository<Car, CarId> {
}
