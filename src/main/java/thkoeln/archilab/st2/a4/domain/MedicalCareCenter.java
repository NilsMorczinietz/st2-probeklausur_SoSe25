package thkoeln.archilab.st2.a4.domain;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import thkoeln.archilab.st2.a4.domainprimitives.MedicalCareCenterException;

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

    @ElementCollection
    private List<String> certifiedDiseases = new ArrayList<>();

    private Integer numberOfDoctors;
    private Integer numberOfNurses;

    @ElementCollection
    private List<Integer> certificationFromYear = new ArrayList<>();
    @ElementCollection
    private List<Integer> certificationUntilYear = new ArrayList<>();

    public MedicalCareCenter( String centerName, Integer numberOfDoctors, Integer numberOfNurses ) {
        this.centerName = centerName;
        this.numberOfDoctors = numberOfDoctors;
        this.numberOfNurses = numberOfNurses;
        this.id = new MedicalCareCenterId();
    }

    public void addCertification( String disease, Integer fromYear, Integer untilYear ) {
        certifiedDiseases.add( disease );
        certificationFromYear.add( fromYear );
        certificationUntilYear.add( untilYear );
    }

    public boolean isCertifiedFor( String disease, Integer year ) {
        if ( disease == null || year == null ) throw new MedicalCareCenterException( "Invalid parameters!" );
        for ( int i = 0; i < certifiedDiseases.size(); i++ ) {
            if ( certifiedDiseases.get( i ).equals( disease ) ) {
                if ( certificationFromYear.get( i ) <= year && year <= certificationUntilYear.get( i ) ) {
                    return true;
                }
            }
        }
        return false;
    }
}
