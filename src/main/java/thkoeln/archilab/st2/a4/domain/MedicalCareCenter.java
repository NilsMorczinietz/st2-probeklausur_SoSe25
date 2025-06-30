package thkoeln.archilab.st2.a4.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import thkoeln.archilab.st2.a4.domainprimitives.Certification;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class MedicalCareCenter {
    @EmbeddedId
    @Setter(AccessLevel.PRIVATE)    // only for JPA
    private MedicalCareCenterId id;

    private String centerName;

    private Integer numberOfDoctors;
    private Integer numberOfNurses;

    public MedicalCareCenter( String centerName, Integer numberOfDoctors, Integer numberOfNurses ) {
        this.centerName = centerName;
        this.numberOfDoctors = numberOfDoctors;
        this.numberOfNurses = numberOfNurses;
        this.id = new MedicalCareCenterId();
    }

    public void addCertification( String disease, Integer fromYear, Integer untilYear ) {
        Certification newCertification = Certification.of(disease, fromYear, untilYear);
        certifications.add(newCertification);
    }

    public boolean isCertifiedFor( String disease, Integer year ){
        for(Certification certification : certifications){
            if(certification.isValidCertificationFor(disease, year)) return true;
        }
        return false;
    }

    @Setter
    @ElementCollection
    @JsonProperty("certifications")
    private List<Certification> certifications = new ArrayList<>();

}
