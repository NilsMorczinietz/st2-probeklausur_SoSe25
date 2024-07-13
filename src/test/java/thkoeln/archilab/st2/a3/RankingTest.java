package thkoeln.archilab.st2.a3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import thkoeln.archilab.st2.a3.course.application.CourseService;
import thkoeln.archilab.st2.a3.course.domain.Course;
import thkoeln.archilab.st2.a3.student.application.StudentService;
import thkoeln.archilab.st2.a3.student.domain.Student;
import thkoeln.archilab.st2.a3.studyprogram.application.StudyProgramService;
import thkoeln.archilab.st2.a3.studyprogram.domain.StudyProgram;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RankingTest {
    @Autowired
    private CourseService courseService;
    @Autowired
    private StudyProgramService studyProgramService;
    @Autowired
    private StudentService studentService;

    private StudyProgram computerScience, businessInformatics;
    private Student s0a, s0b, s7, s11, s15, s16, s22, s23, s32;
    private Course db2, st2, mci;

    @BeforeEach
    public void setUp() {
        courseService.deleteAll();
        studentService.deleteAll();
        studyProgramService.deleteAll();

        initializeStudyPrograms();
        initializeStudents();
        initializeCourses();
    }

    private void initializeStudyPrograms() {
        computerScience = new StudyProgram( "Informatik" );
        studyProgramService.save( computerScience );
        businessInformatics = new StudyProgram( "Wirtschaftsinformatik" );
        studyProgramService.save( businessInformatics );
    }

    private void initializeStudents() {
        s0a = new Student( "Oskar Romero", 98821, computerScience );
        s0a.setAverageGrade( 0 );
        studentService.save( s0a );
        s0b = new Student( "Angela Tretnick", 17728, businessInformatics );
        s0b.setAverageGrade( 0 );
        studentService.save( s0b );
        s7 = new Student( "Miriam Klahr", 29982, businessInformatics );
        s7.setAverageGrade( 7 );
        studentService.save( s7 );
        s11 = new Student( "Erkan Bol", 75542, computerScience );
        s11.setAverageGrade( 11 );
        studentService.save( s11 );
        s15 = new Student( "Hannah Gerkievicz", 43223, businessInformatics );
        s15.setAverageGrade( 15 );
        studentService.save( s15 );
        s16 = new Student( "Erkan Bol", 75542, computerScience );
        s16.setAverageGrade( 16 );
        studentService.save( s16 );
        s22 = new Student( "Lukas Schmitz", 99811, businessInformatics );
        s22.setAverageGrade( 22 );
        studentService.save( s22 );
        s23 = new Student( "Hossein Aminollah", 23221, computerScience );
        s23.setAverageGrade( 23 );
        studentService.save( s23 );
        s32 = new Student( "Liana Pandarovna", 12111, computerScience );
        s32.setAverageGrade( 32 );
        studentService.save( s32 );
    }

    private void initializeCourses() {
        db2 = new Course( "DB2");
        db2.addToStudyProgram( computerScience );
        db2.addToStudyProgram( businessInformatics );
        db2.enroll( s32 );
        db2.enroll( s0a );
        db2.enroll( s7 );
        db2.enroll( s23 );
        courseService.save( db2 );

        st2 = new Course( "ST2" );
        st2.addToStudyProgram( computerScience );
        st2.enroll( s23 );
        st2.enroll( s32 );
        st2.enroll( s0a );
        st2.enroll( s11 );
        st2.enroll( s16 );
        courseService.save( st2 );

        mci = new Course( "MCI" );
        mci.addToStudyProgram( computerScience );
        mci.addToStudyProgram( businessInformatics );
        mci.enroll( s22 );
        mci.enroll( s7 );
        mci.enroll( s15 );
        mci.enroll( s16 );
        courseService.save( mci );
    }

    @Test
    public void testCourseRanking() {
        // given
        // when
        // then
        assertEquals( 4, s0a.rankingIn( db2 ) );
        assertEquals( 1, s32.rankingIn( st2 ) );
        assertEquals( 2, s16.rankingIn( mci ) );
        assertEquals( 0, s22.rankingIn( st2 ) );
    }


    @Test
    public void testUnsuccessfulAddingCourse() {
        // given
        // when
        // then
        assertNull( st2.addToStudyProgram( businessInformatics ) );
        assertNotNull( st2.addToStudyProgram( null ) );
    }

    @Test
    public void testPrintStudent() {
        // given
        // when
        // then
        assertEquals( "Oskar Romero, Matr.Nr. 98821, eingeschrieben in Informatik",
                studentService.printStudent( s0a ) );
    }

    @Test
    public void testFindStudyProgramById() {
        // given
        UUID nonExistingStudyProgramId = UUID.randomUUID();
        UUID computerScienceId = computerScience.getId();

        // when
        // then
        StudyProgram s1 = studyProgramService.findById( nonExistingStudyProgramId );
        assertEquals( "This program doesn't exist", s1.getName() );
        StudyProgram s2 = studyProgramService.findById( computerScienceId );
        assertEquals( computerScience, s2 );
    }

}
