package com.attilaslearning.cruddemo.dao;

import com.attilaslearning.cruddemo.entity.Course;
import com.attilaslearning.cruddemo.entity.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO {

    //define field for entity manager
    //inject entity manager using constructor injection
    // Add @Transactional annotation to save method

    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional //since we are saving/updating the database
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findById(int theId) {
        return entityManager.find(Instructor.class, theId);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        //retrieve the instructor
        Instructor instructor = entityManager.find(Instructor.class, id);

        //get the courses
        List<Course> courses = instructor.getCourses();

        //break association between instructor and courses to avoid constraint violation
        for (Course course : courses) {
            course.setInstructor(null);
        }

        //delete the instructor
        entityManager.remove(instructor);
    }

    @Override
    public List<Course> findCoursesByInstructorDetail(int theId) {

        //create query
        TypedQuery<Course> query = entityManager.createQuery(
                "from Course where instructor.id = :data", Course.class);
        query.setParameter("data", theId);

        //execute query
        List<Course> courses = query.getResultList();


        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {
        TypedQuery<Instructor> query = entityManager.createQuery(
                "select i from Instructor i " +
                        "JOIN FETCH i.courses " +
                        "JOIN FETCH i.instructorDetail " +
                        "where i.id = :theInstructorId",
                Instructor.class);
        query.setParameter("theInstructorId", theId);

        Instructor instructor = query.getSingleResult();
        return instructor;
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void update(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course findCourseById(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }

    @Override
    @Transactional
    public void save(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course findCourseAndReviewsById(int id) {
        //create query
        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c " +
                        "JOIN FETCH c.reviews " +
                        "where c.id = :courseId", Course.class);

        //execute query
        query.setParameter("courseId", id);

        Course course = query.getSingleResult();

        return course;
    }


}
