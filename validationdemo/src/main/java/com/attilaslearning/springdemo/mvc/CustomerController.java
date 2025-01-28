package com.attilaslearning.springdemo.mvc;

import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    // add an initbinder.. to convert trim input strings
    //remove leadin and trailing whitespaces
    //resolve issue for our validation
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/showForm")
    public String showForm(Model theModel) {
        theModel.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @PostMapping("/processForm")//@Valid will tell SpringMVC to perform validation.
    public String processForm(
        @Valid @ModelAttribute("customer") Customer theCustomer,
        BindingResult theBindingResult){ //BindingResult will hold the result of the validation

        System.out.println("Last name: |" + theCustomer.getLastName() + "|");

        //in messages.properties, we can overwrite the error message
        System.out.println("Binding result: " + theBindingResult.toString());

        System.out.println("\n\n\n\n\n");

        if (theBindingResult.hasErrors()){
            return "customer-form";
        } else {
            return "customer-confirmation";
        }
    }
}
