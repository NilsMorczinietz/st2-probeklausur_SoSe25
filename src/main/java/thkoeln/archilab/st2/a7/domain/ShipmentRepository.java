package thkoeln.archilab.st2.a7.domain;


import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ShipmentRepository extends CrudRepository<Shipment, ShipmentId> {
    List<Shipment> findShipmentsByCustomerNameEquals(String customerName);
}
