package thkoeln.archilab.st2.a6.doctor.application;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thkoeln.archilab.st2.a6.doctor.domain.Doctor;
import thkoeln.archilab.st2.a6.doctor.domain.DoctorId;
import thkoeln.archilab.st2.a6.doctor.domain.exceptions.DoctorCreateException;

import java.util.UUID;

@RestController
@RequestMapping("/doctors")
public class DoctorRESTController {

    private final ModelMapper modelMapper = new ModelMapper();

    private final DoctorApplicationService doctorApplicationService;


    @Autowired
    public DoctorRESTController(DoctorApplicationService doctorApplicationService) {
        this.doctorApplicationService = doctorApplicationService;
    }

    // Reminder: Es müssen nur die ersten beiden Anforderungen implementiert werden, alle anderen nicht!
    // TODO implement (1) Daten eines `Doctors` abfragen (ohne Ausgabe der `AppointmentSlots`)
    // URI: /doctors/{doctor-id}
    @GetMapping("/{idStr}")
    public ResponseEntity<DoctorDTO> getDoctorById(@PathVariable String idStr) {

        // ─── 1. Konvertiere und validiere Parameter ───────────────────────────────
        DoctorId doctorId;
        try {
            System.out.println("ID: " + idStr);
            doctorId = new DoctorId(UUID.fromString(idStr));
        } catch (RuntimeException ex) {
            throw new DoctorCreateException("Invalid UUID format." + ex.getMessage());
        }

        // ─── 2. Führe die Business-Logik aus ──────────────────────────────────────
        Doctor doctor = doctorApplicationService.findById(doctorId);

        // ─── 3. Wandle in DTO um ──────────────────────────────────────────────────
        DoctorDTO dto = modelMapper.map(doctor, DoctorDTO.class);

        // ─── 4. Rückgabe ──────────────────────────────────────────────────────────
        return ResponseEntity.ok(dto);
    }


    // TODO implement (2) Spezialisierung (`specialization`) eines `Doctor` ändern
    // URI: /doctors/{doctor-id}
    @PatchMapping(path = "/{idStr}")
    public ResponseEntity<Void> patchDoctor(
            @PathVariable String idStr,
            @RequestBody DoctorDTO doctorDTO
    ) {

        // ─── 1. Konvertiere und validiere Parameter ───────────────────────────────
        DoctorId userId;
        try {
            userId = new DoctorId(UUID.fromString(idStr));
        } catch (IllegalArgumentException ex) {
            throw new DoctorCreateException("Invalid UUID format.");
        }

        Doctor doctor = doctorApplicationService.findById(userId);

        if (doctorDTO == null || doctorDTO.getSpecialization() == null || doctorDTO.getSpecialization().isBlank())
            throw new DoctorCreateException("Empty");

        doctor.setSpecialization(doctorDTO.getSpecialization());

        // ─── 2. Führe die Business-Logik aus ──────────────────────────────────────
        doctorApplicationService.save(doctor);

        // ─── 3. Wandle in DTO um ──────────────────────────────────────────────────
        // ─── 4. Rückgabe mit Status 201 Created ───────────────────────────────────
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
