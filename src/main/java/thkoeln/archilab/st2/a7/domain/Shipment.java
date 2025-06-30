package thkoeln.archilab.st2.a7.domain;


import jakarta.persistence.ElementCollection;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Shipment {
    @EmbeddedId
    @Setter(AccessLevel.PRIVATE)    // only for JPA
    private ShipmentId id;

    private String customerName;
    private boolean withinEU;

    @ElementCollection( fetch = FetchType.EAGER )
    private List<Container> containers = new ArrayList<>();

    public Shipment( String customerName, boolean withinEU ) {
        if ( customerName == null || customerName.isEmpty() ) throw new ShipmentException( "Invalid parameters!" );
        this.id = new ShipmentId();
        this.customerName = customerName;
        this.withinEU = withinEU;
    }

    public Float calculatePrice(){
        float costs = 0;
        for(Container container : containers){
            costs += container.calculatePrice();
        }
        if(!this.withinEU) costs += 500;
        return costs;
    }
}
