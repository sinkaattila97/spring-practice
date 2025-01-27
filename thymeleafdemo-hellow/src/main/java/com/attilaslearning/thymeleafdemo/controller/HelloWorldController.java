package com.attilaslearning.thymeleafdemo.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    // new controller method to show the initial HTML form
    @RequestMapping("/showForm")  //with @GetMapping or @PostMapping you can restrict the HTTP method
    public String showForm() {
        return "helloworld-form";
    }
    // controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    @RequestMapping("/processFormVersionTwo")
    public String letShoutDude(HttpServletRequest request, Model model) {
        //read request parameter form the HTTP form
        String theName = request.getParameter("studentName");
        //convert the data to all caps
        theName = theName.toUpperCase();
        //create the message
        String result = "Yo! " + theName;
        //add message to the model
        model.addAttribute("message", result);
        return "helloworld";
    }

    @PostMapping("/processFormVersionTree") //if I set this to @GetMapping, i get the studentName in the url http://localhost:8080/processFormVersionTree?studentName=asd
    public String processFormVersionTree(@RequestParam("studentName") String theName,
                                         Model model) {
        //convert the data to all caps
        theName = theName.toUpperCase();
        //create the message
        String result = "Hey! " + theName;
        //add message to the model
        model.addAttribute("message", result);
        return "helloworld";
    }


}
