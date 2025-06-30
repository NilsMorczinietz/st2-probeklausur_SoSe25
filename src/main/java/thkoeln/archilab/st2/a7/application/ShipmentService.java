package thkoeln.archilab.st2.a7.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thkoeln.archilab.st2.a7.domain.Shipment;
import thkoeln.archilab.st2.a7.domain.ShipmentRepository;

import java.util.List;

@Service
public class ShipmentService {
    private final ShipmentRepository shipmentRepository;

    @Autowired
    public ShipmentService( ShipmentRepository shipmentRepository ) {
        this.shipmentRepository = shipmentRepository;
    }

    public Float calculateTotalShipmentPriceOfCustomer(String customerName){
        System.out.println(customerName);
        List<Shipment> shipments = shipmentRepository.findShipmentsByCustomerNameEquals(customerName);
        System.out.println(shipments);

        float costs = 0;
        for(Shipment shipment : shipments){
            costs += shipment.calculatePrice();
        }

        return costs;
    }

    public void saveShipment(Shipment shipment){
        shipmentRepository.save(shipment);
    }
}
