package com.attilaslearning.demo.rest;

public class StudentNotFoundException extends RuntimeException{
    //custom exeption class
    public StudentNotFoundException(String message) {
        super(message);
    }

    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotFoundException(Throwable cause) {
        super(cause);
    }

}
