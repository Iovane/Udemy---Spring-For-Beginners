package com.practice.curddemo;

import com.practice.curddemo.dao.AppDAO;
import com.practice.curddemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CurddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {

//			createCourseAndStudents(appDAO);

//			findCourseAndStudents(appDAO);

//			findStudentAndCourses(appDAO);

//			addMoreCoursesForStudents(appDAO);

//			deleteCourse(appDAO);

//			deleteStudent(appDAO);

		};
	}

	private void deleteStudent(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Deleting student id: " + theId);

		appDAO.deleteStudentById(theId);

		System.out.println("Done!");
	}

	private void addMoreCoursesForStudents(AppDAO appDAO) {

		int theId = 2;
		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);

		// create more courses
		Course tempCourse1 = new Course("Niggas - How to love them (Challenge)");
		Course tempCourse2 = new Course("White people - Shit they do to survive");

		// courses to student
		tempStudent.addCourse(tempCourse1);
		tempStudent.addCourse(tempCourse2);

		System.out.println("Updating student: " + tempStudent);
		System.out.println("associated courses: " + tempStudent.getCourses());

		appDAO.update(tempStudent);

		System.out.println("Done!");

	}

	private void findStudentAndCourses(AppDAO appDAO) {

		int theId = 2;

		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);

		System.out.println("Student: " + tempStudent);
		System.out.println("associated courses: " + tempStudent.getCourses());

		System.out.println("Done!");
	}

	private void findCourseAndStudents(AppDAO appDAO) {

		int theId = 10;
		Course tempCourse = appDAO.findCourseAndStudentsById(theId);

		System.out.println("Loaded course " + tempCourse);
		System.out.println("Students: " + tempCourse.getStudents());

		System.out.println("Done!");
	}

	private void createCourseAndStudents(AppDAO appDAO) {

		// create a course
		Course tempCourse = new Course("Dragon Balls - Why are they so big?");

		// create the students
		Student tempStudent1 = new Student("Mamasha", "Mdidari", "m.mdidari@gmail.com");
		Student tempStudent2 = new Student("Magari", "Mdivani", "m.mdivani@gmail.com");
		Student tempStudent3 = new Student("Nikusha", "Jalagonia", "n.jalagonia@gmail.com");

		// add students to the course
		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);
		tempCourse.addStudent(tempStudent3);

		// save the course and associated students
		System.out.println("Saving course " + tempCourse);
		System.out.println("associated students: " + tempCourse.getStudents());

		appDAO.save(tempCourse);
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {

		int theId = 11;

		System.out.println("Deleting course " + theId);

		appDAO.deleteCourseById(theId);

		System.out.println("Done!");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {

		// get the course and reviews
		int theId = 11;
		Course tempCourse = appDAO.findCourseAndReviewsById(theId);

		// print the course
		System.out.println(tempCourse);

		// print the reviews
		System.out.println(tempCourse.getReviews());

		System.out.println("Done!");
	}

	private void createCourseAndReviews(AppDAO appDAO)   {

		// create a course
		Course tempCourse = new Course("Rogor vcemot bavshvebi?");

		// add some reviews
		tempCourse.addReview(new Review("DZLIVS WESIERI KURSI! WOW!! AMAZING!!!"));
		tempCourse.addReview(new Review("viswavle joxit cema kargad ^_^ madloba <3"));
		tempCourse.addReview(new Review("aeeeeeee ramagaaaariaaaaa"));


		// save the course and leverage the cascade all
		System.out.println("Saving course: " + tempCourse);
		System.out.println("Course reviews: " + tempCourse.getReviews());

		appDAO.save(tempCourse);
	}

	private void deleteCourse(AppDAO appDAO) {
		int theId = 11;

		System.out.println("Deleting course id: " + theId);

		appDAO.deleteCourseById(theId);

		System.out.println("Done!");
	}

	private void updateCourse(AppDAO appDAO) {

		int theId = 10;

		// find the course
		System.out.println("Find course by id: " + theId);
		Course tempCourse = appDAO.findCourseById(theId);

		System.out.println("Updating course: " + tempCourse);
		tempCourse.setTitle("Rogor gavashvilot shvili?");

		appDAO.update(tempCourse);

	}

	private void updateInstructor(AppDAO appDAO) {

		int theId = 1;

		// find the instructor
		System.out.println("Finding instructor with id " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		// update the instructor
		System.out.println("Updating instructor " + tempInstructor);
		tempInstructor.setLastName("Gavshordi");

		appDAO.update(tempInstructor);

		System.out.println("Done!");

	}

	private void findInstructorWitCoursesJoinFetch(AppDAO appDAO) {

		int theId = 3;

		// find the instructor
		System.out.println("Finding instructor with id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated courses: " + tempInstructor.getCourses());

		System.out.println("Done!");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding Instructor with id: " + theId);

		Instructor theInstructor = appDAO.findInstructorById(theId);

		System.out.println("theInstructor: " + theInstructor);

		// find courses for instructor
		System.out.println("Finding Courses for Instructor with id: " + theId);

		List<Course> courses = appDAO.findCoursesByInstructorId(theId);

		// associate the objects
		theInstructor.setCourses(courses);

		System.out.println("the associated courses: " + theInstructor.getCourses());
		System.out.println("Done!");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding Instructor with id: " + theId);

		Instructor theInstructor = appDAO.findInstructorById(theId);

		System.out.println("theInstructor: " + theInstructor);
		System.out.println("the associated courses: " + theInstructor.getCourses());

		System.out.println("Done!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		// create the instructor
		Instructor tempInstructor =
				new Instructor("Anastasia", "Chikovani", "a.chikovani@gmail.com");

		InstructorDetail tempInstructorDetial =
				new InstructorDetail("https://www.youtube.com/dedas-ar-vukvarvar",
						"Dedas unda shevakvaro tavi da taki");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetial);

		// create some courses
		Course tempCourse = new Course("Rogor Gavxdet Kali");
		Course tempCourse1 = new Course("Rogor Davrchet Kali");
		Course tempCourse2 = new Course("Rogor Moviqcet Tu Vegar Davrchit Kalad");

		// add course to instructor
		tempInstructor.add(tempCourse);
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		/* another way to set courses for instructor
		List<Course> coursesList = new ArrayList<Course>();

		coursesList.add(new Course("Rato ar vuyvarvar dedas?"));
		coursesList.add(new Course("Rogor shevayvaro tavi dedas?"));
		coursesList.add(new Course("Rogor vasiamovno dedas?"));
		coursesList.add(new Course("Rogor davalago otaxi?"));

		for (Course course : coursesList) {
			course.setInstructor(tempInstructor);
		}

		tempInstructor.setCourses(coursesList);
		 */

		// save the instructor
		System.out.println("Saving instructor: " + tempInstructor);
		System.out.println("The Courses: " + tempInstructor.getCourses());

		// NOTE: this will ALSO save the courses
		// because of CascadeType.PERSIST
		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 4;
		System.out.println("deleting instructor detail id: " + theId);

		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Done!!!!!");
	}

	private void findInstructorDetail(AppDAO appDAO) {

		int theId = 3;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

		System.out.println("tempInstructorDetail: " + tempInstructorDetail);
		System.out.println("the associated instructor only: " + tempInstructorDetail.getInstructor());

	}

	private void deleteInstructor(AppDAO appDAO) {

		int theId = 1;
		System.out.println("deleting instructor id: " + theId);

		appDAO.deleteInstructorById(theId);
		System.out.println("Done!");

	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 4;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated instructorDetail only: " + tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {

//		// create the instructor
//		Instructor tempInstructor =
//				new Instructor("Iovane", "Chikovani", "i.chikovani@gmail.com");
//
//		InstructorDetail tempInstructorDetial =
//				new InstructorDetail("https://www.youtube.com/channel/UCDPYt0EQ-aOQF7jaChqccsA",
//						"Fallout 4");


		// create the instructor
		Instructor tempInstructor =
				new Instructor("Anastasia", "Chikovani", "a.chikovani@gmail.com");

		InstructorDetail tempInstructorDetial =
				new InstructorDetail("https://www.youtube.com/shartva",
						"Shartva");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetial);

		// save the instructor
		//
		// NOTE: this will ALSO save the details object
		// because of CascadeType.ALL
		//
		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Done!");

	}

}
