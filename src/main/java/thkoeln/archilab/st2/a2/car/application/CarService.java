package thkoeln.archilab.st2.a2.car.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thkoeln.archilab.st2.a2.car.domain.Car;
import thkoeln.archilab.st2.a2.car.domain.CarId;
import thkoeln.archilab.st2.a2.car.domain.CarRepository;
import thkoeln.archilab.st2.a2.race.domain.Race;

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

    public Car findById( CarId id ) {
        if ( id == null ) throw new IllegalArgumentException( "Id must not be null" );
        return carRepository.findById( id ).orElseThrow( () -> new IllegalArgumentException( "Car not found" ) );
    }

    public void registerCarForRace( Car car, Race race ) {
        if ( car == null ) throw new IllegalArgumentException( "Car must not be null" );
        if ( race == null ) throw new IllegalArgumentException( "Race must not be null" );

        if( car.getRaces().contains( race.getId() ) )
            throw new IllegalArgumentException( "Car is already registered" );
        car.getRaces().add( race.getId() );
        carRepository.save( car );
    }
}
