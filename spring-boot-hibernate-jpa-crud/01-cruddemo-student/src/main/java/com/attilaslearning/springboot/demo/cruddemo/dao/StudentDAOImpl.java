package com.attilaslearning.springboot.demo.cruddemo.dao;

import com.attilaslearning.springboot.demo.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //Marks the class as a Spring Bean. Supports component scanning, translates JDBC exceptions
public class StudentDAOImpl implements StudentDAO{

    //define field for entity manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implemens the methods for the DAO
    @Override
    @Transactional
    public void saveStudent(Student student) {
        System.out.println("Saving student...");
        entityManager.persist(student);
    }

    @Override
    public Student getStudentById(Integer id) {
        System.out.println("Getting student...");
        return entityManager.find(Student.class, id);

    }

    @Override
    public List<Student> getAllStudents() {
        System.out.println("Getting all students...");
        return entityManager.createQuery("from Student", Student.class).getResultList();
        //note: this is NOT the name of the db table. All JPQL syntax is based on entity name and entity fields
    }

   @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> theQuery = entityManager.createQuery("from Student s where s.lastName = :lastName", Student.class);
        theQuery.setParameter("lastName", lastName);
    return theQuery.getResultList();
}

    @Override
    @Transactional
    public void updateStudent(Student student) {
        System.out.println("Updating student...");
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public int deleteStudent(Student student) {
        System.out.println("Deleting student...");

        int numRowsDeleted = entityManager.createQuery("delete from Student s where s.id = :id")
                .setParameter("id", student.getId())
                .executeUpdate();
        return numRowsDeleted;
    }

    @Override
    @Transactional
    public int deleteAllStudent(){
        System.out.println("Deleting all students...");
        int numRowsDeleted = entityManager.createQuery("delete from Student").executeUpdate();

        return numRowsDeleted;
    }
}
