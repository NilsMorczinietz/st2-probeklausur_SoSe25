package thkoeln.archilab.st2.a3.student.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface StudentRepository extends CrudRepository<Student, StudentId> {
    List<Student> findAll();
}
