package thkoeln.archilab.st2.a6;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import thkoeln.archilab.st2.a6.doctor.application.DoctorDTO;
import thkoeln.archilab.st2.a6.doctor.domain.Doctor;
import thkoeln.archilab.st2.a6.doctor.domain.DoctorRepository;


import jakarta.transaction.Transactional;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
public class RESTTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private DoctorRepository doctorRepository;

    private Doctor doctor1, doctor2;

    @BeforeEach
    public void setUp() {
        doctorRepository.deleteAll();
        doctor1 = new Doctor( UUID.randomUUID(), "Dr. Eisenbieger", "Orthopädie" );
        doctor2 = new Doctor( UUID.randomUUID(), "Dr. Schlaumeier", "Allgemeinmedizin" );
        doctorRepository.save( doctor1 );
        doctorRepository.save( doctor2 );
    }


    @Test
    public void testGetQuery() throws Exception {
        // given
        String uri1 = "/doctors/" + doctor1.getId();

        // when
        // then
        mockMvc.perform( get( uri1 ) )
                .andExpect( status().isOk() )
                .andExpect( jsonPath( "$.name" ).value( doctor1.getName() ) );
    }


    @Test
    public void testPatch() throws Exception {
        // given
        String newSpeciality = "Wunderheilung";
        DoctorDTO patchDTO = new DoctorDTO( null, null, newSpeciality );
        ObjectMapper objectMapper = new ObjectMapper();
        String patchJson = objectMapper.writeValueAsString( patchDTO );
        String patchUri = "/doctors/" + doctor2.getId();

        // when
        mockMvc.perform( patch( patchUri ).contentType( APPLICATION_JSON ).content( patchJson ) )
                .andExpect( status().isOk() ).andReturn();

        // then
        mockMvc.perform( get( patchUri ) )
                .andExpect( status().isOk() )
                .andExpect( jsonPath( "$.specialization" ).value( newSpeciality ) );
    }


    @Test
    public void testErrorCodes() throws Exception {
        // given
        String invalidUri = "/doctors/" + UUID.randomUUID();
        String uri1 = "/doctors/" + doctor1.getId();

        // when
        // then
        mockMvc.perform( get( invalidUri ) )
                .andExpect( status().isNotFound() );
        mockMvc.perform( patch( invalidUri ).contentType( APPLICATION_JSON ).content( "{}" ) )
                .andExpect( status().isNotFound() ).andReturn();
        mockMvc.perform( patch( uri1 ).contentType( APPLICATION_JSON ).content( "{}" ) )
                .andExpect( status().isUnprocessableEntity() ).andReturn();
    }
}
