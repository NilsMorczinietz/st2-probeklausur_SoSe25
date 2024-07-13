package thkoeln.archilab.st2.a3.studyprogram.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface StudyProgramRepository extends CrudRepository<StudyProgram, UUID> {
}
