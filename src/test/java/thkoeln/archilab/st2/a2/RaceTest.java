package thkoeln.archilab.st2.a2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import thkoeln.archilab.st2.a2.car.application.CarService;
import thkoeln.archilab.st2.a2.car.domain.Car;
import thkoeln.archilab.st2.a2.motorclub.application.MotorClubService;
import thkoeln.archilab.st2.a2.race.application.RaceService;
import thkoeln.archilab.st2.a2.race.domain.Race;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD;

@SpringBootTest
@DirtiesContext(classMode = BEFORE_EACH_TEST_METHOD)
public class RaceTest {
    @Autowired
    private CarService carService;

    @Autowired
    private MotorClubService motorClubService;

    Car bmw, audi, mercedes;
    Race nuerburgring, hockenheim, spa;
    @Autowired
    private RaceService raceService;

    @BeforeEach
    public void setUp() {
        // Initialize cars
        bmw = new Car( "BMW", "M3", 327837 );
        audi = new Car( "Audi", "RS4", 7268221 );
        mercedes = new Car( "Mercedes", "C43 AMG", 895894 );
        bmw = carService.save( bmw );
        audi = carService.save( audi );
        mercedes = carService.save( mercedes );

        // Initialize races
        nuerburgring = new Race( "Nürburgring", LocalDate.of( 2024, 8, 12 ) );
        hockenheim = new Race( "Hockenheim", LocalDate.of( 2024, 9, 2 ) );
        spa = new Race( "Spa", LocalDate.of( 2024, 9, 23 ) );
        nuerburgring = raceService.addRace( nuerburgring );
        hockenheim = raceService.addRace( hockenheim );
        spa = raceService.addRace( spa );
    }

    @Test
    public void testRegisterCarForRace() {
        // given
        carService.registerCarForRace( bmw, nuerburgring );
        carService.registerCarForRace( audi, hockenheim );
        carService.registerCarForRace( mercedes, spa );
        carService.registerCarForRace( mercedes, nuerburgring );

        // when
        Car checkBmw = carService.findById( bmw.getId() );
        Car checkAudi = carService.findById( audi.getId() );
        Car checkMercedes = carService.findById( mercedes.getId() );

        // then
        assertTrue( checkBmw.getRaces().contains( nuerburgring.getId() ) );
        assertFalse( checkBmw.getRaces().contains( hockenheim.getId() ) );
        assertTrue( checkAudi.getRaces().contains( hockenheim.getId() ) );
        assertFalse( checkAudi.getRaces().contains( nuerburgring.getId() ) );
        assertTrue( checkMercedes.getRaces().contains( spa.getId() ) );
        assertTrue( checkMercedes.getRaces().contains( nuerburgring.getId() ) );
    }

    @Test
    public void testDontRegisterCarForRaceTwice() {
        // given
        carService.registerCarForRace( bmw, nuerburgring );

        // when
        // then
        assertThrows( IllegalArgumentException.class,
                () -> { carService.registerCarForRace( bmw, nuerburgring ); } );
    }

}
