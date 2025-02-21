package com.attilaslearning.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    // this is where we add all of our related advices for logging

    // let's start with an @Before advice

    //@Before("execution(public void com.attilaslearning.aopdemo.dao.AccountDAO.addAccount())")
    //@Before("execution(public void addAccount())")                                                //matched for all method that start with addAccount()
    //@Before("execution(public void add*())")
    //@Before("execution(* add*())")                                                                //matched for all method that start with add
    //@Before("execution(* add*(com.attilaslearning.aopdemo.Account, ..))")                         //matched for all method that start with add and have Account as first parameter, .. means 0 or more parameters
    //@Before("execution(* add*(..))")                                                                //matched for any number of parameters
    @Before("execution(* com.attilaslearning.aopdemo.dao.*.*(..))")                                                                //matched
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on method()");
    }
}
