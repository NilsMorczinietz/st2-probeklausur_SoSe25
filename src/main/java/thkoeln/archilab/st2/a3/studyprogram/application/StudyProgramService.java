package thkoeln.archilab.st2.a3.studyprogram.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thkoeln.archilab.st2.a3.studyprogram.domain.StudyProgram;
import thkoeln.archilab.st2.a3.studyprogram.domain.StudyProgramRepository;

import java.util.UUID;

@Service
public class StudyProgramService {
    private StudyProgramRepository studyProgramRepository;

    @Autowired
    public StudyProgramService( StudyProgramRepository studyProgramRepository ) {
        this.studyProgramRepository = studyProgramRepository;
    }

    public void deleteAll() {
        studyProgramRepository.deleteAll();
    }

    public void save( StudyProgram studyProgram ) {
        studyProgramRepository.save( studyProgram );
    }

    public StudyProgram findById( UUID id ) {
        return studyProgramRepository.findById( id ).orElse( new StudyProgram( "This program doesn't exist" ) );
    }
}
