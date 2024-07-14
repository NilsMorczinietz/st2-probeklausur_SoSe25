package thkoeln.archilab.st2.a3.student.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thkoeln.archilab.st2.a3.course.application.CourseService;
import thkoeln.archilab.st2.a3.course.domain.Course;
import thkoeln.archilab.st2.a3.student.domain.Student;
import thkoeln.archilab.st2.a3.student.domain.StudentRepository;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    private CourseService courseService;

    @Autowired
    public StudentService( StudentRepository studentRepository, CourseService courseService ) {
        this.studentRepository = studentRepository;
        this.courseService = courseService;
    }

    public Student addStudent( Student student) {
        if ( student == null ) throw new IllegalArgumentException( "Student is null" );
        return studentRepository.save( student );
    }


    public Student getStudentById( UUID studentId ) {
        if ( studentId == null ) throw new IllegalArgumentException( "Student ID is null or empty" );
        return studentRepository.findById( studentId ).orElseThrow(
                () -> new IllegalArgumentException( "Student not found" ) );
    }


    public Float averageEctsLoad() {
        List<Student> students = studentRepository.findAll();
        Float sum = 0f;
        for ( Student student : students )
            sum += ectsLoadForStudent( student );
        return sum / Float.valueOf( students.size() );
    }


    public Integer ectsLoadForStudent( Student student ) {
        if ( student == null ) throw new IllegalArgumentException( "Student is null" );
        List<Course> courses = courseService.coursesForStudent( student );
        Integer ects = 0;
        for ( Course course : courses )
            ects += course.getEcts();
        return ects;
    }



}
