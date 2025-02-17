package com.attilaslearning.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "course")
public class Course {
    //define out fields
    //define constructor
    //define getter-setter
    //define toString
    //annotate fields

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    //if you delete a course, it should not delete the instructor so no CascadeType.REMOVE (no cascade all)
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
                            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "instructor_id")  //so it knows which instructor belongs to
    private Instructor instructor;


    public Course() {
    }

    public Course(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", instructor=" + instructor +
                '}';
    }
}
