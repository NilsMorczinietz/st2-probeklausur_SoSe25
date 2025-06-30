package thkoeln.archilab.st2.a7;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import thkoeln.archilab.st2.a7.application.ShipmentService;
import thkoeln.archilab.st2.a7.domain.Container;
import thkoeln.archilab.st2.a7.domain.Shipment;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class ShipmentTests {

    @Autowired
    private ShipmentService shipmentService;

    private Container container1, container2;
    private Shipment shipment1, shipment2, shipment3;
    private float container1Price, container2Price, shipment1Price, shipment2Price, shipment3Price, mustermannPrice, musterfrauPrice;

    @BeforeEach
    public void setUp(){
        container1 = new Container(10F, 10F ,10F);
        container1Price = (10*10*10)*800 + 200;

        container2 = new Container(1F, 1F ,1F);
        container2Price = 800 + 200;

        shipment1 = new Shipment("mustermann", true);
        shipment1.setContainers(List.of(container1, container2));
        shipment1Price = container1Price + container2Price + 0;

        shipment2 = new Shipment("musterfrau", false);
        shipment2.setContainers(List.of(container1, container2));
        shipment2Price = container1Price + container2Price + 500;

        shipment3 = new Shipment("mustermann", false);
        shipment3Price = 500;

        mustermannPrice = shipment1Price + shipment3Price;
        musterfrauPrice = shipment2Price;

        shipmentService.saveShipment(shipment1);
        shipmentService.saveShipment(shipment2);
        shipmentService.saveShipment(shipment3);
    }

    @AfterEach
    public void shutDown(){

    }

    @Test
    public void testContainerCosts(){
        // given
        // when
        float calculatedContainer1Costs = container1.calculatePrice();
        float calculatedContainer2Costs = container2.calculatePrice();

        // then
        assertEquals(container1Price, calculatedContainer1Costs);
        assertEquals(container2Price, calculatedContainer2Costs);
    }

    @Test
    public void testSigleShipmentCosts(){
        // given
        // when
        float calculatedShipment1Price = shipment1.calculatePrice();
        float calculatedShipment2Price = shipment2.calculatePrice();
        float calculatedShipment3Price = shipment3.calculatePrice();

        // then
        assertEquals(shipment1Price, calculatedShipment1Price);
        assertEquals(shipment2Price, calculatedShipment2Price);
        assertEquals(shipment3Price, calculatedShipment3Price);
    }

    @Test
    public void testUserShipments(){
        // given
        // when
        float calculatedMustermannPrice = shipmentService.calculateTotalShipmentPriceOfCustomer("mustermann");
        float calculatedMusterfrauPrice = shipmentService.calculateTotalShipmentPriceOfCustomer("musterfrau");

        // then
        assertEquals(mustermannPrice, calculatedMustermannPrice);
        assertEquals(musterfrauPrice, calculatedMusterfrauPrice);
    }

    // Edge Case: Kunde ohne Lieferung
    // Validierung von Container größen
}
