package thkoeln.archilab.st2.a4.domainprimitives;

import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED) // für JPA
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Certification {

    public static Certification of(String disease, Integer fromYear, Integer untilYear) {
        if (disease == null || disease.isBlank()) throw new MedicalCareCenterException("Disease is not valid!");
        if (fromYear == null || fromYear < 1990) throw new MedicalCareCenterException("FromYear is not valid!");
        if (untilYear == null) throw new MedicalCareCenterException("untilYear is not valid!");
        if(fromYear > untilYear) throw new MedicalCareCenterException("years not valid!");

        return new Certification(disease, fromYear, untilYear);
    }

    private String disease;

    private Integer fromYear;

    private Integer untilYear;

    public boolean isValidCertificationFor(String disease, Integer year){
        if(!this.disease.equals(disease)) return false;
        if(year < fromYear) return false;
        if(year > untilYear) return false;

        return true;
    }
}
