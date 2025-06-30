package thkoeln.archilab.st2.a2.race.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thkoeln.archilab.st2.a2.car.application.CarService;
import thkoeln.archilab.st2.a2.race.domain.Race;
import thkoeln.archilab.st2.a2.race.domain.RaceRepository;

@Service
public class RaceService {
    private final RaceRepository raceRepository;
    private final CarService carService;

    @Autowired
    public RaceService(
            RaceRepository raceRepository,
            CarService carService
    ){
        this.raceRepository = raceRepository;
        this.carService = carService;
    }

    public Race addRace(Race race ) {
        if ( race == null ) throw new IllegalArgumentException( "Race must not be null" );
        return raceRepository.save( race );
    }

    public void validateRace(Race race){
        if ( race == null ) throw new IllegalArgumentException( "Race must not be null" );
    }
}
