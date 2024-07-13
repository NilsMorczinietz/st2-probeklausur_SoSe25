package thkoeln.archilab.st2.a4.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import thkoeln.archilab.st2.a4.domainprimitives.MedicalCareCenterException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class MedicalCareCenter {
    @Id @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

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
