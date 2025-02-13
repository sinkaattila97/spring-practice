package com.attilaslearning.cruddemo.dao;

import com.attilaslearning.cruddemo.entity.Instructor;
import com.attilaslearning.cruddemo.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteById(int id);

    void deleteInstructorDetailById(int id);
}
