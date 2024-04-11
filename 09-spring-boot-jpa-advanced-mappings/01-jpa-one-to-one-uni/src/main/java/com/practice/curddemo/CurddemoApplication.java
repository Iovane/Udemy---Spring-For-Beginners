package com.practice.curddemo;

import com.practice.curddemo.dao.AppDAO;
import com.practice.curddemo.entity.Instructor;
import com.practice.curddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CurddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {

//			createInstructor(appDAO);

//			findInstructor(appDAO);

//			deleteInstructor(appDAO);
		};
	}

	private void deleteInstructor(AppDAO appDAO) {

		int theId = 2;
		System.out.println("deleting instructor id: " + theId);

		appDAO.deleteInstructorById(theId);
		System.out.println("Done!");

	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated instructorDetail only: " + tempInstructor.getInstructorDetail());

	}

	private void createInstructor(AppDAO appDAO) {
		/*
		// create the instructor
		Instructor tempInstructor =
				new Instructor("Iovane", "Chikovani", "i.chikovani@gmail.com");

		InstructorDetail tempInstructorDetial =
				new InstructorDetail("https://www.youtube.com/channel/UCDPYt0EQ-aOQF7jaChqccsA",
						"Fallout 4");
						*/

		// create the instructor
		Instructor tempInstructor =
				new Instructor("Mariam", "Chikovani", "m.chikovani@gmail.com");

		InstructorDetail tempInstructorDetial =
				new InstructorDetail("https://www.youtube.com",
						"QAQVA");

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
