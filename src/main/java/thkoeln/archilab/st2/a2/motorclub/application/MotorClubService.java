package thkoeln.archilab.st2.a2.motorclub.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thkoeln.archilab.st2.a2.car.domain.CarRepository;
import thkoeln.archilab.st2.a2.motorclub.domain.MotorClubRepository;
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
}
