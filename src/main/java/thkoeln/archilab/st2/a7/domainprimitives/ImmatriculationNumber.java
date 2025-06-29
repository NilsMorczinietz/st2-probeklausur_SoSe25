package thkoeln.archilab.st2.a7.domainprimitives;

import lombok.*;
import thkoeln.archilab.st2.a3.student.domain.Student;

import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;

/**
 * Domain primitive for the immatriculation number of a student.
 * The number is coded as an 8-digit integer, with
 * - the digits 1-2 represent the year of immatriculation
 * - the digits 3-4 represent the month of immatriculation
 * - the last four digits represent a unique number for the student
 */
@Embeddable
@Getter
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor( access = AccessLevel.PROTECTED )
public class ImmatriculationNumber {
    // the 8-digit integer
    private Integer number;

    // the student this immatriculation number belongs to
    @OneToOne
    private Student student;

    /**
     * Factory method to create an immatriculation number from its components.
     * @param year  the year of immatriculation (2 digits)
     * @param month the month of immatriculation
     * @param uniqueNumber the unique number of the student
     * @return an immatriculation number with the given components
     */
    public static ImmatriculationNumber of( Integer year, Integer month, Integer uniqueNumber ) {
        if (year < 0 || year > 35 || month < 1 || month > 12 || uniqueNumber < 0 || uniqueNumber > 9999)
            throw new IllegalArgumentException("Invalid immatriculation number components");
        ImmatriculationNumber immatriculationNumber = new ImmatriculationNumber();
        immatriculationNumber.number = year * 1000000 + month * 10000 + uniqueNumber;
        return immatriculationNumber;
    }

    public Integer getYear() {
        return number / 1000000;
    }

    public Integer getMonth() {
        return (number / 10000) % 100;
    }

    public Integer getUniqueNumber() {
        return number % 1000;
    }

    /**
     * @return Returns the current semester number of the student to whom
     *         this immatriculation number belongs.
     */
    public Integer currentSemesterNumber() {
        LocalDate now = LocalDate.now();
        int yearNow = now.getYear() - 2000; // I know, a bit unsafe ;-)
        int monthNow = now.getMonthValue();
        int monthDiff = (yearNow - getYear()) * 12 + monthNow - getMonth();
        int semesterDiff = monthDiff / 6;
        return semesterDiff + 1;
    }

    @Override
    public String toString() {
        return number.toString();
    }
}
