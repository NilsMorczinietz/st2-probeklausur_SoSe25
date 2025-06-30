package thkoeln.archilab.st2.a2.car.domain;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import lombok.*;
import thkoeln.archilab.st2.a2.race.domain.RaceId;

import java.util.ArrayList;
import java.util.List;

/**
 * A semiprofessional or professional athlete
 */

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = {"id"})
public class Car {
    @EmbeddedId
    @Setter(AccessLevel.PRIVATE)    // only for JPA
    private CarId id;

    // brand (Marke) and type of the car
    private String brand;
    private String type;

    // the registration number of the car
    private Integer registrationNumber;

    public Car(String brand, String type, Integer registrationNumber) {
        this.brand = brand;
        this.type = type;
        this.registrationNumber = registrationNumber;
        this.id = new CarId();
    }

    // the races in which this car has participated or will participate in the future
    @ElementCollection(fetch = FetchType.EAGER)
    private final List<RaceId> races = new ArrayList<>();

    public String carToString(Car car) {
        String printString = "Car " + car.getBrand() + " " + car.getType()
                + " (" + car.getRegistrationNumber() + ")";
        return printString;
    }

    public boolean isRaceAlreadyRegistered(RaceId raceId){
        return this.getRaces().contains(raceId);
    }

    public void addRace(RaceId raceId){
        races.add(raceId);
    }
}
