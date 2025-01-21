package com.attilaslearning.cruddemo.dao;

import com.attilaslearning.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    //define the fields for the entity manager
    private EntityManager entityManager;
    //set up constructor injection
    @Autowired
    public EmployeeDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        //create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
        //execute query and get result list
        List<Employee> employees = theQuery.getResultList();
        //return the results
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        //get employee
        Employee theEmployee = entityManager.find(Employee.class, theId);
        //return employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        //save or update the employee
        Employee dbEmployee = entityManager.merge(theEmployee);
        //update with id from db... so we can get generated id for save/insert. If it finds the id, it will update the record, else it will insert a new record.
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {
        //delete object with primary key
        Employee theEmployee = entityManager.find(Employee.class, theId);
        entityManager.remove(theEmployee);
    }
}
