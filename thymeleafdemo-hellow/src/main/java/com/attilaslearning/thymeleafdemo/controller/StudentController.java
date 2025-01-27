package com.attilaslearning.thymeleafdemo.controller;

import com.attilaslearning.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @Value("${operatingSystems}")
    private List<String> systems;

    @GetMapping("/showStudentForm")
    public String showForm(Model model) {
        //create a student object
        Student theStudent = new Student();

        //add student object to the model
        model.addAttribute("student", theStudent);

        model.addAttribute("countries", countries);

        model.addAttribute("languages", languages);

        model.addAttribute("favoriteSystems", systems);

        return "student-form";
    }

    @PostMapping("/processStudentForm")//@ModelAttribute binds the form data to the Student object from the student-form.html
    public String processForm(@ModelAttribute("student") Student theStudent) {

        //log the input data
        System.out.println("theStudent: " + theStudent.getFirstName()
                + " " + theStudent.getLastName());

        return "student-confirmation";
    }
}
