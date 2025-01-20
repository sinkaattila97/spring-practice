package com.attilaslearning.springboot.demo.cruddemo.dao;

import com.attilaslearning.springboot.demo.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void saveStudent(Student student);
    Student getStudentById(Integer id);
    List<Student> getAllStudents();
    List<Student> findByLastName(String whereClause);
    void updateStudent(Student student);
    int deleteStudent(Student student);

    int deleteAllStudent();
}
