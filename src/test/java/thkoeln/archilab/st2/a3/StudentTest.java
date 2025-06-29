package thkoeln.archilab.st2.a3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import thkoeln.archilab.st2.a3.course.application.CourseService;
import thkoeln.archilab.st2.a3.course.domain.Course;
import thkoeln.archilab.st2.a3.domainprimitives.ImmatriculationNumber;
import thkoeln.archilab.st2.a3.student.application.StudentService;
import thkoeln.archilab.st2.a3.student.domain.Student;
import thkoeln.archilab.st2.a3.student.domain.StudentRepository;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD;

@SpringBootTest
@DirtiesContext(classMode = BEFORE_EACH_TEST_METHOD)
public class StudentTest {
    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    // the ImmatriculationNumber "current semesters" are calculated based
    // on the current date. Therefore this test is only valid until end August 24 ;-).
    private ImmatriculationNumber im1, im2, im6, im11;

    private Student angela1, erkan2, miriam6, oskar11;
    private Course st2, pp, ps;

    @BeforeEach
    public void setUp() {
        // the ImmatriculationNumbers are created so that the reflect the semester numbers
        // given in the variable names. I.e. im2 is for a student in semester 2.
        LocalDate d1 = enrollmentDateForSemesterNumber( 1 );
        LocalDate d2 = enrollmentDateForSemesterNumber( 2 );
        LocalDate d6 = enrollmentDateForSemesterNumber( 6 );
        LocalDate d11 = enrollmentDateForSemesterNumber( 11 );
        im1 = ImmatriculationNumber.of( d1.getYear() % 100, d1.getMonthValue(), 1 );
        im2 = ImmatriculationNumber.of( d2.getYear() % 100, d2.getMonthValue(), 2 );
        im6 = ImmatriculationNumber.of( d6.getYear() % 100, d6.getMonthValue(), 6 );
        im11 = ImmatriculationNumber.of( d11.getYear() % 100, d11.getMonthValue(), 11 );

        initializeStudents();
        initializeCourses();
        enrollStudents();
    }


    /**
     * Initializes the students used in the tests.
     */
    private void initializeStudents() {
        // The variable for the student is encoded with her/his semester number
        angela1 = new Student( "Angela Müller", im1 );
        angela1 = studentService.addStudent( angela1 );
        erkan2 = new Student( "Erkan Bol", im2 );
        erkan2 = studentService.addStudent( erkan2 );
        miriam6 = new Student( "Miriam Petrovic", im6 );
        miriam6 = studentService.addStudent( miriam6 );
        oskar11 = new Student( "Oskar Dreher", im11 );
        oskar11 = studentService.addStudent( oskar11 );
    }


    /**
     * @param semesterNumber
     * @return The date on which a student needs to be enrolled, in order to be in the given
     *         semester number.
     */
    private LocalDate enrollmentDateForSemesterNumber( int semesterNumber ) {
        LocalDate enrollmentDate = LocalDate.now().minusMonths( semesterNumber * 6 );
        return enrollmentDate;
    }


    /**
     * Initializes the courses used in the tests.
     */
    private void initializeCourses() {
        st2 = new Course( "Softwaretechnik 2", 6 );
        st2 = courseService.addCourse( st2 );
        pp = new Course( "Praxisprojekt", 15 );
        pp = courseService.addCourse( pp );
        ps = new Course( "Praxissemester", 30 );
        ps = courseService.addCourse( ps );
    }


    private void enrollStudents() {
        courseService.enrollStudentInCourse( angela1, st2 );
        courseService.enrollStudentInCourse( erkan2, st2 );
        courseService.enrollStudentInCourse( miriam6, st2 );
        courseService.enrollStudentInCourse( oskar11, st2 );

        courseService.enrollStudentInCourse( miriam6, pp );
        courseService.enrollStudentInCourse( oskar11, ps );
    }


    @Test
    public void testAverageEctsLoad() {
        // given, when, then
        assertEquals( 6, studentService.ectsLoadForStudent( angela1 ) );
        assertEquals( 6, studentService.ectsLoadForStudent( erkan2 ) );
        assertEquals( 21, studentService.ectsLoadForStudent( miriam6 ) );
        assertEquals( 36, studentService.ectsLoadForStudent( oskar11 ) );
        // sum = 69, average = 69 / 4 = 17.25
        assertEquals( 17.25f, studentService.averageEctsLoad(), 0.01f );
    }


    @Test
    public void averageSemesterNumber() {
        // ST2: 1 + 2 + 6 + 11 = 20, average = 20 / 4 = 5
        // in the other courses, there is only one student, so the average is the semester number of that student
        assertEquals( 5f, st2.averageSemesterNumber(), 0.01f );
        assertEquals( 6f, pp.averageSemesterNumber(), 0.01f );
        assertEquals( 11f, ps.averageSemesterNumber(), 0.01f );
    }
}
