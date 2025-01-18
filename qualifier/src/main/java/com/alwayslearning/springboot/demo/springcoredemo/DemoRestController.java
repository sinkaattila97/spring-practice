package com.alwayslearning.springboot.demo.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {
    public String sayHello() {
        return "Hello World!";
    }

    @GetMapping("/")
    public String sayHelloAgain() {
        return "Hello World Again!";
    }

    private Coach myCoach;

    /**
     * @Autowired tells Spring to inject a dependency
     */
    @Autowired
    public DemoRestController(@Qualifier("baseballCoach") Coach theCoach) {
        myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
