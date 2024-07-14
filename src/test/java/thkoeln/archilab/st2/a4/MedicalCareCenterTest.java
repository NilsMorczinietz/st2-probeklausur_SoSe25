package thkoeln.archilab.st2.a4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import thkoeln.archilab.st2.a4.domain.MedicalCareCenter;
import thkoeln.archilab.st2.a4.domain.MedicalCareCenterRepository;
import thkoeln.archilab.st2.a4.domainprimitives.MedicalCareCenterException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MedicalCareCenterTest {
    @Autowired
    private MedicalCareCenterRepository medicalCareCenterRepository;

    private MedicalCareCenter medicalCareCenter;

    @BeforeEach
    public void setup() {
        medicalCareCenterRepository.deleteAll();
        medicalCareCenter = new MedicalCareCenter( "Wiehl Medical Care Center", 5, 7 );
        medicalCareCenterRepository.save( medicalCareCenter );
    }


    @Test
    public void addCertificationsAndCheck() {
        // given
        medicalCareCenter.addCertification( "Broken Leg", 1992, 2000 );
        medicalCareCenter.addCertification( "Twisted Ankle", 2017, 2025 );
        medicalCareCenter.addCertification( "Broken Leg", 2007, 2025 );

        // when
        // then
        assertTrue( medicalCareCenter.isCertifiedFor( "Broken Leg", 2023 ) );
        assertTrue( medicalCareCenter.isCertifiedFor( "Twisted Ankle", 2023 ) );
        assertFalse ( medicalCareCenter.isCertifiedFor( "Broken Leg", 2004 ) );
        assertFalse ( medicalCareCenter.isCertifiedFor( "Common Cold", 2023 ) );
    }


    @Test
    public void addInvalidCertifications() {
        // given
        // when
        // then
        assertThrows( MedicalCareCenterException.class,
                () -> medicalCareCenter.addCertification( null, 1993, 2017 ) );
        assertThrows( MedicalCareCenterException.class,
                () -> medicalCareCenter.addCertification( "Broken Leg", null, 2020 ) );
        assertThrows( MedicalCareCenterException.class,
                () -> medicalCareCenter.addCertification( "Broken Leg", 1993, null ) );
        assertThrows( MedicalCareCenterException.class,
                () -> medicalCareCenter.addCertification( "Broken Leg", 2021, 1992 ) );
    }
}
