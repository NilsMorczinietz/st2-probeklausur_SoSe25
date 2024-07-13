package thkoeln.archilab.st2.a3.course.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thkoeln.archilab.st2.a3.course.domain.Course;
import thkoeln.archilab.st2.a3.course.domain.CourseRepository;

@Service
public class CourseService {
    private CourseRepository courseRepository;

    @Autowired
    public CourseService( CourseRepository courseRepository ) {
        this.courseRepository = courseRepository;
    }

    public void deleteAll() {
        courseRepository.deleteAll();
    }

    public void save( Course course ) {
        courseRepository.save( course );
    }
}
