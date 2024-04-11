package practice.demo.rest;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import practice.demo.entity.Student;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    // define @PostConstruct to load the student data... only once!
    @PostConstruct
    public void loadData(){

        theStudents = new ArrayList<>();

        theStudents.add(new Student("Lakaka", "Shmakaka"));
        theStudents.add(new Student("Makaka", "Akaka"));
        theStudents.add(new Student("Mariam", "Wiwaka"));

    }

    // define endpoint for "/student" - return a list of students
    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }

    // define endpoint or "/students/{studentId}" - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        // just index into the list... keep  it simple for now

        // check the studentId against list size
        if ((studentId >= theStudents.size()) || (studentId<0)){
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return theStudents.get(studentId);
    }

    // add an exception handler using @ExceptionHandler... moved for global use

}
