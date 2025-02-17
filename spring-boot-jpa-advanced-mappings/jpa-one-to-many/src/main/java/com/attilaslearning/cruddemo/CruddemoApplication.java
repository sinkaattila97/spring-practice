package com.attilaslearning.cruddemo;

import com.attilaslearning.cruddemo.dao.AppDAO;
import com.attilaslearning.cruddemo.entity.Course;
import com.attilaslearning.cruddemo.entity.Instructor;
import com.attilaslearning.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
			//deleteInstructor(appDAO);
			//createInstructorWithCourses(appDAO);
			//findInstructorWithCourses(appDAO);
			//findCoursesForInstructor(appDAO);
			//findInstructorWithCoursesJoinFetch(appDAO);

			//updateInstructor(appDAO);
			//updateCourses(appDAO);

			//deleteInstructor(appDAO);
			deleteCourse(appDAO);

		};
	}

	private void deleteCourse(AppDAO appDAO) {
		int theId = 10;
		appDAO.deleteCourseById(theId);
		System.out.println("Course deleted: " + theId);
	}

	private void updateCourses(AppDAO appDAO) {
		int theId = 10;
		Course tempCourse = appDAO.findCourseById(theId);

		System.out.println("Course: " + tempCourse);
		tempCourse.setTitle("Air Guitar Masterclass");
		appDAO.update(tempCourse);
		System.out.println(tempCourse + " updated!");
	}

	private void updateInstructor(AppDAO appDAO) {
		int theId = 1;
		Instructor tempInstructor = appDAO.findById(theId);

		System.out.println("Instructor: " + tempInstructor);
		tempInstructor.setFirstName("John");
		tempInstructor.setLastName("Bravo");
		tempInstructor.setEmail("johnyybravo@yahoo.com");
		appDAO.update(tempInstructor);
		System.out.println(tempInstructor + " updated!");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int theId = 1;

		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);
		System.out.println("Instructor: " + tempInstructor);

		System.out.println("The associated courses for this instructor are: " + tempInstructor.getCourses());


	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId = 1;
		Instructor tempInstructor = appDAO.findById(theId);
		System.out.println("Instructor: " + tempInstructor);


		//find courses for the instructor
		System.out.println("Courses: " + appDAO.findCoursesByInstructorDetail(theId));
		List<Course> courses = appDAO.findCoursesByInstructorDetail(theId);

		//associate the object
		tempInstructor.setCourses(courses);
		System.out.println("Courses: " + tempInstructor.getCourses());
		System.out.println("Done");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId = 1;
		Instructor tempInstructor = appDAO.findById(theId);
		System.out.println("Instructor: " + tempInstructor);
		System.out.println("Courses: " + tempInstructor.getCourses());
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		//Create an Instructor object
		Instructor tempInstructor =
				new Instructor("Mike", "Oxlong", "mike@gmail.com");

		//create InstructorDetail object
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("mikeoxlong", "movies");

		//associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		//Creating courses
		Course course1 = new Course("Air Guitar - The Ultimate Guide");
		Course course2 = new Course("The Pinball Masterclass");

		//add courses to instructor
		tempInstructor.add(course1);
		tempInstructor.add(course2);

		//save the insturctor
		/*
		* NOTE: this will also save the courses because of CascadeType.PERSIST
		*
		* */
		System.out.println("Saving instructor: " + tempInstructor);
		System.out.println("Courses: " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);
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
