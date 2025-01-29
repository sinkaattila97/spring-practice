package com.attilaslearning.springboot.thymeleafdemo.dao;

import com.attilaslearning.springboot.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code LOL!

    //add a method to sort by last name. Naming convention is important here. Find detalis in the Spring Data JPA documentation
    List<Employee> findAllByOrderByLastNameAsc();

}
