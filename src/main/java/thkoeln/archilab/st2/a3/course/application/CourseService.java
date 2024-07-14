package thkoeln.archilab.st2.a3.course.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thkoeln.archilab.st2.a3.course.domain.Course;
import thkoeln.archilab.st2.a3.course.domain.CourseRepository;
import thkoeln.archilab.st2.a3.student.domain.Student;

import java.util.List;
import java.util.UUID;

@Service
public class CourseService {
    private CourseRepository courseRepository;

    @Autowired
    public CourseService( CourseRepository courseRepository ) {
        this.courseRepository = courseRepository;
    }

    public Course addCourse( Course course ) {
        if ( course == null ) throw new IllegalArgumentException( "Course is null" );
        return courseRepository.save( course );
    }


    public Course getCourseById( UUID courseId ) {
        if ( courseId == null ) throw new IllegalArgumentException( "Course ID is null or empty" );
        return courseRepository.findById( courseId ).orElseThrow(
                () -> new IllegalArgumentException( "Course not found" ) );
    }


    public void enrollStudentInCourse( Student student, Course course ) {
        if ( student == null || course == null )
            throw new IllegalArgumentException( "Course or student is null" );
        course.enrollStudent( student );
        courseRepository.save( course );
    }


    public List<Course> coursesForStudent( Student student ) {
        if ( student == null ) throw new IllegalArgumentException( "Student is null" );
        return courseRepository.findByEnrolledStudentsContains( student );
    }

}
