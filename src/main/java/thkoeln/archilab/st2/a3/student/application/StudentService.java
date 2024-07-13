package thkoeln.archilab.st2.a3.student.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thkoeln.archilab.st2.a3.student.domain.Student;
import thkoeln.archilab.st2.a3.student.domain.StudentRepository;
import thkoeln.archilab.st2.a3.studyprogram.application.StudyProgramService;
import thkoeln.archilab.st2.a3.studyprogram.domain.StudyProgram;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    private StudyProgramService studyProgramService;

    @Autowired
    public StudentService( StudentRepository studentRepository, StudyProgramService studyProgramService ) {
        this.studentRepository = studentRepository;
        this.studyProgramService = studyProgramService;
    }

    public void deleteAll() {
        studentRepository.deleteAll();
    }

    public void save( Student student) {
        studentRepository.save( student );
    }

    public String printStudent( Student student ) {
        String printString = student.getName();
        StudyProgram studyProgram = studyProgramService.findById( student.getStudyProgramId() );
        printString += ", Matr.Nr. " + student.getMatriculationNumber();
        printString += ", eingeschrieben in " + studyProgram.getName();
        return printString;
    }
}
