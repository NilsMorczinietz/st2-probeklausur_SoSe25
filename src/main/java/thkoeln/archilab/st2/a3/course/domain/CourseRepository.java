package thkoeln.archilab.st2.a3.course.domain;

import org.springframework.data.repository.CrudRepository;
import thkoeln.archilab.st2.a3.student.domain.StudentId;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, CourseId> {
    List<Course> findByEnrolledStudentsContains( StudentId studentId );
}
