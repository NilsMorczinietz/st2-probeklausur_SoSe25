package thkoeln.archilab.st2.a3.student.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thkoeln.archilab.st2.a3.student.domain.Courseable;
import thkoeln.archilab.st2.a3.student.domain.Student;
import thkoeln.archilab.st2.a3.student.domain.StudentId;
import thkoeln.archilab.st2.a3.student.domain.StudentRepository;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    private CourseableServiceInterface courseableServiceInterface;

    @Autowired
    public StudentService(
            StudentRepository studentRepository,
            CourseableServiceInterface courseableServiceInterface
    ) {
        this.courseableServiceInterface = courseableServiceInterface;
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        if (student == null) throw new IllegalArgumentException("Student is null");
        return studentRepository.save(student);
    }


    public Student getStudentById(StudentId studentId) {
        if (studentId == null) throw new IllegalArgumentException("Student ID is null or empty");
        return studentRepository.findById(studentId).orElseThrow(
                () -> new IllegalArgumentException("Student not found"));
    }


    public Float averageEctsLoad() {
        List<Student> students = studentRepository.findAll();
        Float sum = 0f;
        for (Student student : students)
            sum += ectsLoadForStudent(student.getId());
        return sum / Float.valueOf(students.size());
    }


    public Integer ectsLoadForStudent(StudentId studentId) {
        if (studentId == null) throw new IllegalArgumentException("StudentId is null");
        List<Courseable> courses = courseableServiceInterface.coursesForStudent(studentId);
        Integer ects = 0;
        for (Courseable course : courses)
            ects += course.getEcts();
        return ects;
    }


}
