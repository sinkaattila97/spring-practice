package com.alwayslearning.springboot.demo.myapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A @RestController is a combination of @Controller and @ResponseBody, meaning that the methods in the class will return data directly instead of a view.
 */
@RestController
public class MyRestController {

    //expose "/" that return "Hello World ("/" being the root URL)"

    /**
     * @GetMapping is a shortcut for @RequestMapping(method = RequestMethod.GET)
     * @return
     * Handling Requests: Methods in a RestController are mapped to HTTP requests using annotations like @GetMapping, @PostMapping, etc. These methods process the request and return the response.
     * Returning Data: The data returned by the methods is automatically converted to JSON or XML format, making it easy to create APIs that can be consumed by clients.
     */

    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }

}
