package thkoeln.archilab.st2.a2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import thkoeln.archilab.st2.a2.car.application.CarService;
import thkoeln.archilab.st2.a2.car.domain.Car;
import thkoeln.archilab.st2.a2.motorclub.application.MotorClubService;
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
        nuerburgring = motorClubService.addRace( nuerburgring );
        hockenheim = motorClubService.addRace( hockenheim );
        spa = motorClubService.addRace( spa );
    }

    @Test
    public void testRegisterCarForRace() {
        // given
        motorClubService.registerCarForRace( bmw, nuerburgring );
        motorClubService.registerCarForRace( audi, hockenheim );
        motorClubService.registerCarForRace( mercedes, spa );
        motorClubService.registerCarForRace( mercedes, nuerburgring );

        // when
        Car checkBmw = carService.findById( bmw.getId() );
        Car checkAudi = carService.findById( audi.getId() );
        Car checkMercedes = carService.findById( mercedes.getId() );

        // then
        assertTrue( checkBmw.getTheRacesInWhichThisCarHasParticipatedOrWillParticipateInTheFuture().contains( nuerburgring.getId() ) );
        assertFalse( checkBmw.getTheRacesInWhichThisCarHasParticipatedOrWillParticipateInTheFuture().contains( hockenheim.getId() ) );
        assertTrue( checkAudi.getTheRacesInWhichThisCarHasParticipatedOrWillParticipateInTheFuture().contains( hockenheim.getId() ) );
        assertFalse( checkAudi.getTheRacesInWhichThisCarHasParticipatedOrWillParticipateInTheFuture().contains( nuerburgring.getId() ) );
        assertTrue( checkMercedes.getTheRacesInWhichThisCarHasParticipatedOrWillParticipateInTheFuture().contains( spa.getId() ) );
        assertTrue( checkMercedes.getTheRacesInWhichThisCarHasParticipatedOrWillParticipateInTheFuture().contains( nuerburgring.getId() ) );
    }

    @Test
    public void testDontRegisterCarForRaceTwice() {
        // given
        motorClubService.registerCarForRace( bmw, nuerburgring );

        // when
        // then
        assertThrows( IllegalArgumentException.class,
                () -> { motorClubService.registerCarForRace( bmw, nuerburgring ); } );
    }

}
