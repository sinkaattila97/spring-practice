package com.attilaslearning.cruddemo.dao;

import com.attilaslearning.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //no need to write any implementation code, we get all the CRUD methods for free
}
