package thkoeln.archilab.st2.a7.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thkoeln.archilab.st2.a7.domain.ShipmentRepository;

@Service
public class ShipmentService {
    private ShipmentRepository shipmentRepository;

    @Autowired
    public ShipmentService( ShipmentRepository shipmentRepository ) {
        this.shipmentRepository = shipmentRepository;
    }
}
