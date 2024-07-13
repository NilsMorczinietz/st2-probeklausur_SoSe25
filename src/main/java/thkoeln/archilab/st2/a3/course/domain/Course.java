package thkoeln.archilab.st2.a3.course.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import thkoeln.archilab.st2.a3.student.domain.Student;
import thkoeln.archilab.st2.a3.studyprogram.domain.StudyProgram;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Setter @Getter
    private String nameOfTheCourseThatCanBeUsedInAllDirectoriesAndLists;

    @ManyToMany
    private List<Student> students = new ArrayList<>();

    @ManyToMany
    @Getter
    private List<StudyProgram> studyPrograms = new ArrayList<>();

    public Course( String nameOfTheCourseThatCanBeUsedInAllDirectoriesAndLists ) {
        this.nameOfTheCourseThatCanBeUsedInAllDirectoriesAndLists = nameOfTheCourseThatCanBeUsedInAllDirectoriesAndLists;
    }


    /**
     * Add this course to a study program
     * @param studyProgram
     * @return null if adding the course was successful, or an error message if not
     */
    public String addToStudyProgram( StudyProgram studyProgram ) {
        if ( studyProgram == null ) return "Can't add to null study program!";
        studyPrograms.add( studyProgram );
        return null;
    }


    /**
     * Enroll a student in this course
     * @param student
     */
    public void enroll( Student student ) {
        students.add( student );
    }


    /**
     * @return the list of all enrolled students (as a clone to be on the safe side)
     */
    public List<Student> enrolledStudents() {
        List<Student> listCopy = new ArrayList<>( students );
        return listCopy;
    }


}
