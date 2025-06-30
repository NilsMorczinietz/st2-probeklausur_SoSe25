package thkoeln.archilab.st2.a2.motorclub.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thkoeln.archilab.st2.a2.car.application.CarService;
import thkoeln.archilab.st2.a2.car.domain.CarRepository;
import thkoeln.archilab.st2.a2.race.application.RaceService;

@Service
public class MotorClubService {
    private final RaceService raceService;
    private final CarService carService;
    private CarRepository carRepository;

    @Autowired
    public MotorClubService(
            CarRepository carRepository,
            RaceService raceService,
            CarService carService
    ) {
        this.carRepository = carRepository;
        this.raceService = raceService;
        this.carService = carService;
    }
}
