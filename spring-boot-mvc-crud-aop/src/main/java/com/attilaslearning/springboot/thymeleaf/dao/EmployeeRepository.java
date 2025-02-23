package com.attilaslearning.springboot.thymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attilaslearning.springboot.thymeleaf.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    public List<Employee> findAllByOrderByLastNameAsc();

}
