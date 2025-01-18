package com.alwayslearning.springboot.demo.springcoredemo.rest;

import com.alwayslearning.springboot.util.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {
    public String sayHello() {
        return "Hello World!";
    }

    private Coach mycoach;

    /**
     * @Autowired tells Spring to inject a dependency
     */
    @Autowired
    public DemoRestController(Coach theCoach) {
        mycoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return mycoach.getDailyWorkout();
    }
}
