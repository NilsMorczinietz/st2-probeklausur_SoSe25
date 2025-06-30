package thkoeln.archilab.st2.a2.car.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thkoeln.archilab.st2.a2.car.domain.Car;
import thkoeln.archilab.st2.a2.car.domain.CarId;
import thkoeln.archilab.st2.a2.car.domain.CarRepository;
import thkoeln.archilab.st2.a2.race.application.RaceService;
import thkoeln.archilab.st2.a2.race.domain.Race;

@Service
public class CarService {
    private CarRepository carRepository;
    private RaceService raceService;

    @Autowired
    public CarService(
            CarRepository carRepository,
            RaceService raceService
    ) {
        this.carRepository = carRepository;
        this.raceService = raceService;
    }

    public Car save( Car car ) {
        if ( car == null ) throw new IllegalArgumentException( "Car must not be null" );
        return carRepository.save( car );
    }

    public Car findById( CarId id ) {
        if ( id == null ) throw new IllegalArgumentException( "Id must not be null" );
        return carRepository.findById( id ).orElseThrow( () -> new IllegalArgumentException( "Car not found" ) );
    }

    public void validateCar(Car car){
        if ( car == null ) throw new IllegalArgumentException( "Car must not be null" );
    }

    public void saveCar( Car car){
        carRepository.save(car);
    }

    public void registerCarForRace(Car car, Race race ) {
        raceService.validateRace(race);
        validateCar(car);

        if(car.isRaceAlreadyRegistered(race.getId()))
            throw new IllegalArgumentException( "Car is already registered" );

        car.addRace(race.getId());
        carRepository.save( car );
    }
}
