package com.attilaslearning.cruddemo.dao;

import com.attilaslearning.cruddemo.entity.Instructor;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findById(int id);

    void deleteById(int id);
}
