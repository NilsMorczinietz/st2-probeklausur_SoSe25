package thkoeln.archilab.st2.a3.student.application;

import thkoeln.archilab.st2.a3.student.domain.Courseable;
import thkoeln.archilab.st2.a3.student.domain.StudentId;

import java.util.List;

public interface CourseableServiceInterface {
    public List<Courseable> coursesForStudent(StudentId studentId);
}