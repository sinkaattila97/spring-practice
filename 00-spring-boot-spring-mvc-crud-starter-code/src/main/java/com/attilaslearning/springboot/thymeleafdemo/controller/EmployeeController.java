package com.attilaslearning.springboot.thymeleafdemo.controller;

import com.attilaslearning.springboot.thymeleafdemo.entity.Employee;
import com.attilaslearning.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    private EmployeeController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        // get employees from db
        List<Employee> theEmployees = employeeService.findAll();

        // add to the spring model
        model.addAttribute("employees", employeeService.findAll());

        //list-employees.html is in the templates/employees folder
        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){

        //create model attribute to bind form data
        Employee theEmployee = new Employee();

        model.addAttribute("employee", theEmployee);

        return "employees/employee-form";

    }
}
