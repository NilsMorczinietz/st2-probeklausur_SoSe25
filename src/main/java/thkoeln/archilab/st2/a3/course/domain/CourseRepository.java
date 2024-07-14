package thkoeln.archilab.st2.a3.course.domain;

import org.springframework.data.repository.CrudRepository;
import thkoeln.archilab.st2.a3.student.domain.Student;

import java.util.List;
import java.util.UUID;

public interface CourseRepository extends CrudRepository<Course, UUID> {
    List<Course> findByEnrolledStudentsContains( Student student );
}
