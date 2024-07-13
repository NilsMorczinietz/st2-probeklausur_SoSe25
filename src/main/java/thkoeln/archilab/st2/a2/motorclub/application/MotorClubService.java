package thkoeln.archilab.st2.a2.motorclub.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thkoeln.archilab.st2.a2.car.domain.Car;
import thkoeln.archilab.st2.a2.car.domain.CarRepository;
import thkoeln.archilab.st2.a2.motorclub.domain.MotorClubRepository;
import thkoeln.archilab.st2.a2.race.domain.Race;
import thkoeln.archilab.st2.a2.race.domain.RaceRepository;

@Service
public class MotorClubService {
    private MotorClubRepository motorClubRepository;
    private RaceRepository raceRepository;
    private CarRepository carRepository;

    @Autowired
    public MotorClubService( MotorClubRepository motorClubRepository,
                             RaceRepository raceRepository,
                             CarRepository carRepository ) {
        this.motorClubRepository = motorClubRepository;
        this.raceRepository = raceRepository;
        this.carRepository = carRepository;
    }


    public Race addRace( Race race ) {
        if ( race == null ) throw new IllegalArgumentException( "Race must not be null" );
        return raceRepository.save( race );
    }


    public void registerCarForRace( Car car, Race race ) {
        if ( car == null ) throw new IllegalArgumentException( "Car must not be null" );
        if ( race == null ) throw new IllegalArgumentException( "Race must not be null" );

        if( car.getTheRacesInWhichThisCarHasParticipatedOrWillParticipateInTheFuture().contains( race ) )
            throw new IllegalArgumentException( "Car is already registered" );
        car.getTheRacesInWhichThisCarHasParticipatedOrWillParticipateInTheFuture().add( race );
        carRepository.save( car );
    }
}
