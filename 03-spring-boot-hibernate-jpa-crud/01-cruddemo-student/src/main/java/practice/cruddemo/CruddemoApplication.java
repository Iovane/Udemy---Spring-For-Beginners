package practice.cruddemo;

import   org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import practice.cruddemo.dao.StudentDAO;
import practice.cruddemo.entity.Student;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
//			createStudent(studentDAO);
			createMultipleStudents(studentDAO);

//			readStudent(studentDAO);
//			queryForStudent(studentDAO);
//			queryForStudentsByLastName(studentDAO);

//			updateStudent(studentDAO);

//			deleteStudent(studentDAO);
//			deleteAllStudents(studentDAO);
			};
		}

	private void deleteAllStudents(StudentDAO studentDAO) {
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student with id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;

		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		System.out.println("Updating student...");
		myStudent.setLastName("Mokakuli");

		studentDAO.update(myStudent);

		System.out.println("Updated student: " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastname("Applebum");

		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudent(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findAll();

		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Kaka", "Makakashka", "kaka@practice.com");

		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		System.out.println("Saved student. Generated id: " + tempStudent.getId());

		System.out.println("Retrieving student based on id...");
		Student myStudent = studentDAO.findById(tempStudent.getId());

		System.out.println(myStudent);
	}

	private void createMultipleStudents (StudentDAO studentDAO) {

		// create multiple students
		System.out.println("Creating 3 student objects ... ");
		Student tempStudent1 = new Student("John", "Doe", "john@practice.com");
		Student tempStudent2 = new Student("Mary", "Public", "mary@practice.com");
		Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@practice.com");

		// save the student objects
		System.out.println("Saving the students");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Paul", "Maxali", "paul@practice.com");

		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}
}
