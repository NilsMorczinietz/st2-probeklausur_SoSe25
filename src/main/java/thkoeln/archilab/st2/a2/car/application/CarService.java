package thkoeln.archilab.st2.a2.car.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thkoeln.archilab.st2.a2.car.domain.Car;
import thkoeln.archilab.st2.a2.car.domain.CarRepository;

import java.util.UUID;

@Service
public class CarService {
    private CarRepository carRepository;

    @Autowired
    public CarService( CarRepository carRepository ) {
        this.carRepository = carRepository;
    }

    public Car save( Car car ) {
        if ( car == null ) throw new IllegalArgumentException( "Car must not be null" );
        return carRepository.save( car );
    }

    public Car findById( UUID id ) {
        if ( id == null ) throw new IllegalArgumentException( "Id must not be null" );
        return carRepository.findById( id ).orElseThrow( () -> new IllegalArgumentException( "Car not found" ) );
    }

    public String carToString( Car car ) {
        String printString = "Car " + car.getB() + " " + car.getT()
                + " (" + car.getRegistrationNumber() + ")";
        return printString;
    }
}
