package com.attilaslearning.demo.rest;

import com.attilaslearning.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents;

    //define @PostConstruct to load the student data only once. If we were to have the list creation and the population in the RequestMapping, the list would be created and populated every time the endpoint is called!!!!
    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Mary", "Public"));
        theStudents.add(new Student("John", "Doe"));
        theStudents.add(new Student("Ajay", "Rao"));
    }

    //define endpoint for "/students" - return list of students
    @RequestMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    //define endpoint for "/students/{studentId}" - return student at index
    @RequestMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        //just index into the list...keep it simple for now

        //check studentId against list size
        if ((studentId >= theStudents.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return theStudents.get(studentId);
    }



}
