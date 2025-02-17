package com.attilaslearning.cruddemo.dao;

import com.attilaslearning.cruddemo.entity.Course;
import com.attilaslearning.cruddemo.entity.Instructor;
import com.attilaslearning.cruddemo.entity.Student;

import java.util.List;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findById(int id);

    void deleteById(int id);

    List<Course> findCoursesByInstructorDetail(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

    void update(Instructor instructor);

    void update(Course course);

    Course findCourseById(int id);

    void deleteCourseById(int id);

    void save(Course course);

    Course findCourseAndReviewsById(int id);

    Course findCourseAndStudentsById(int id);

    Student findStudentAndCoursesByStudentId(int id);


}
