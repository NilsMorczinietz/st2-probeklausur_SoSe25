package thkoeln.archilab.st2.a3.course.application;

import org.springframework.stereotype.Service;
import thkoeln.archilab.st2.a3.course.domain.Course;
import thkoeln.archilab.st2.a3.student.application.CourseableServiceInterface;
import thkoeln.archilab.st2.a3.student.domain.Courseable;
import thkoeln.archilab.st2.a3.student.domain.StudentId;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseableService implements CourseableServiceInterface {
    private final CourseService courseService;

    public CourseableService(CourseService courseService) {
        this.courseService = courseService;
    }

    @Override
    public List<Courseable> coursesForStudent(StudentId studentId) {
        List<Courseable> courseables = new ArrayList<>();
        for(Course course : courseService.coursesForStudent(studentId)){
            courseables.add((Courseable) course);
        }
        return  courseables;
    }
}
