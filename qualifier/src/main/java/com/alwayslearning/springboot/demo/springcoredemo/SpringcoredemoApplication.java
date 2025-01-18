package com.alwayslearning.springboot.demo.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

	/**
	 * Web Browser asks the DemoController the /dailyworkout wich asks the Coach for the daily workout method
	 * Coach returns the daily workout method to the DemoController wich returns the String to the Web Browser
	 */

}
