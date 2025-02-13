package com.attilaslearning.cruddemo;

import com.attilaslearning.cruddemo.dao.AppDAO;
import com.attilaslearning.cruddemo.entity.Instructor;
import com.attilaslearning.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			deleteInstructor(appDAO);
		};
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 1;
		appDAO.deleteById(theId);
		System.out.println("Instructor deleted: " + theId);
	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Instructor: " + appDAO.findById(theId));

		Instructor tempInstructor = appDAO.findById(theId);
		System.out.println("Instructor: " + tempInstructor);
		System.out.println("Instructor Detail: " + tempInstructor.getInstructorDetail());


	}

	private void createInstructor(AppDAO appDAO) {

		//Create an Instructor object
		/*Instructor tempInstructor =
				new Instructor("John", "Doe", "johnny@bravo.com");

		//create InstructorDetail object
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("johnnybravo", "cartoon");*/

		//Create an Instructor object
		Instructor tempInstructor =
				new Instructor("Mike", "Oxlong", "mike@gmail.com");

		//create InstructorDetail object
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("mikeoxlong", "movies");

		//associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		//save the insturctor
		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);

	}

}
