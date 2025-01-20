package com.attilaslearning.springboot.demo.cruddemo;

import com.attilaslearning.springboot.demo.cruddemo.dao.StudentDAO;
import com.attilaslearning.springboot.demo.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			//readStudent(studentDAO,2);
			//removeStudent(studentDAO,4);
			//findAllWithLastName(studentDAO, "Doe");
			//updateStudent(studentDAO, 1);
			//deleteAllStudents(studentDAO);
			listAllStudents(studentDAO);

		};
	}

	private void updateStudent(StudentDAO studentDAO, int id) {
		//get student by id
		System.out.println("Getting student with id 1...");
		Student tempStudent = studentDAO.getStudentById(id);

		//update student
		System.out.println("Updating student...");
		tempStudent.setEmail("johndoe@gmail.com");
		studentDAO.updateStudent(tempStudent);

		System.out.println("Update complete: " + tempStudent);
	}

	private void findAllWithLastName(StudentDAO studentDAO, String lastName) {
		//find all students with last name
		System.out.println("Finding all students with last name " + lastName + "...");
		List<Student> students = studentDAO.findByLastName(lastName);
		for (Student student : students) {
			System.out.println(student);
		}
	}


	private void readStudent(StudentDAO studentDAO, int id) {
		//get student by id
		System.out.println("Getting student with id 1...");
		Student tempStudent = studentDAO.getStudentById(id);
		System.out.println("Get complete: " + tempStudent);
	}

	private void listAllStudents(StudentDAO studentDAO) {
    // list all students
    System.out.println("Listing all students...");
    List<Student> students = studentDAO.getAllStudents();
    for (Student student : students) {
        System.out.println(student);
    }
}

	private void createMultipleStudents(StudentDAO studentDAO) {
		//create multiple students
		System.out.println("Creating 3 student objects...");
		Student tempStudent1 = new Student("Mark", "Walberg", "bigmark@email.com");
		Student tempStudent2 = new Student("Peter", "Jackson", "petethej@email.com");
		Student tempStudent3 = new Student("David", "Copperfield", "copydavy@email.com");

		//save the students
		studentDAO.saveStudent(tempStudent1);
		studentDAO.saveStudent(tempStudent2);
		studentDAO.saveStudent(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		//create student object
		System.out.println("Creating student object");
		Student tempStudent = new Student("John", "Doe", "johnnydoey@email.com");

		//save student object
		System.out.println("Saving student");
		studentDAO.saveStudent(tempStudent);

		//display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());

	}

	void removeStudent(StudentDAO studentDAO, int id) {
		//get student by id
		System.out.println("Getting student with id " + id + "...");
		Student tempStudent = studentDAO.getStudentById(id);
		System.out.println("Get complete: " + tempStudent);

		//delete student
		System.out.println("Deleting student...");
		int numRowsDeleted = studentDAO.deleteStudent(tempStudent);
		System.out.println("Delete complete: " + tempStudent);

	}

	int deleteAllStudents(StudentDAO studentDAO) {
		//delete all students
		System.out.println("Deleting all students...");
		int numRowsDeleted =  studentDAO.deleteAllStudent();
		return numRowsDeleted;
	}

}
