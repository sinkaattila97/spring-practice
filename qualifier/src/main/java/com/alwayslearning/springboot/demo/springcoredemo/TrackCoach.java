package com.alwayslearning.springboot.demo.springcoredemo;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{
public String getDailyWorkout() {
    return "I have run 5k!";
}

}
