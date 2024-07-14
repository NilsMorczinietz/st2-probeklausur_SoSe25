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

    private Student  angela, erkan, miriam, oskar;
    private Course st2, pp, ps;

    @BeforeEach
    public void setUp() {
        im1 = ImmatriculationNumber.of( 24, 5, 1 );
        im2 = ImmatriculationNumber.of( 23, 11, 2 );
        im6 = ImmatriculationNumber.of( 21, 9, 6 );
        im11 = ImmatriculationNumber.of( 19, 3, 11 );

        initializeStudents();
        initializeCourses();
        enrollStudents();
    }

    private void initializeStudents() {
        angela = new Student( "Angela Müller1", im1 );
        angela = studentService.addStudent( angela );
        erkan = new Student( "Erkan Bol2", im2 );
        erkan = studentService.addStudent( erkan );
        miriam = new Student( "Miriam Petrovic6", im6 );
        miriam = studentService.addStudent( miriam );
        oskar = new Student( "Oskar Dreher11", im11 );
        oskar = studentService.addStudent( oskar );
    }


    private void initializeCourses() {
        st2 = new Course( "Softwaretechnik 2", 6 );
        st2 = courseService.addCourse( st2 );
        pp = new Course( "Praxisprojekt", 15 );
        pp = courseService.addCourse( pp );
        ps = new Course( "Praxissemester", 30 );
        ps = courseService.addCourse( ps );
    }


    private void enrollStudents() {
        courseService.enrollStudentInCourse( angela, st2 );
        courseService.enrollStudentInCourse( erkan, st2 );
        courseService.enrollStudentInCourse( miriam, st2 );
        courseService.enrollStudentInCourse( oskar, st2 );

        courseService.enrollStudentInCourse( miriam, pp );
        courseService.enrollStudentInCourse( oskar, ps );
    }


    @Test
    public void testAverageEctsLoad() {
        // given, when, then
        assertEquals( 6, studentService.ectsLoadForStudent( angela ) );
        assertEquals( 6, studentService.ectsLoadForStudent( erkan ) );
        assertEquals( 21, studentService.ectsLoadForStudent( miriam ) );
        assertEquals( 36, studentService.ectsLoadForStudent( oskar ) );
        // sum = 69, average = 69 / 4 = 17.25
        assertEquals( 17.25f, studentService.averageEctsLoad(), 0.01f );
    }


    @Test
    public void averageSemesterNumber() {
        // 1 + 2 + 6 + 11 = 20, average = 20 / 4 = 5
        assertEquals( 5f, st2.averageSemesterNumber(), 0.01f );
        assertEquals( 6f, pp.averageSemesterNumber(), 0.01f );
        assertEquals( 11f, ps.averageSemesterNumber(), 0.01f );
    }
}
