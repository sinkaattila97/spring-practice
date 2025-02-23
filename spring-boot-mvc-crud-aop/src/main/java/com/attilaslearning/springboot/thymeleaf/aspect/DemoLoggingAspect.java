package com.attilaslearning.springboot.thymeleaf.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {

    // setup logger
    private Logger myLogger = Logger.getLogger(getClass().getName());

    // setup pointcut declarations for CONTROLLER, SERVICE, and DAO
    @Pointcut("execution(* com.attilaslearning.springboot.thymeleaf.controller.*.*(..))")
    private void forControllerPackage() {
    }

    @Pointcut("execution(* com.attilaslearning.springboot.thymeleaf.service.*.*(..))")
    private void forServicePackage() {
    }

    @Pointcut("execution(* com.attilaslearning.springboot.thymeleaf.dao.*.*(..))")
    private void forDAOPackage() {
    }

    // combine pointcut declarations
    @Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
    private void forAppFlow() {
    }

    // add @Before advice
    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint) {

        // display method we are calling
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("\n=====>>> Executing @Before advice on method " + theMethod);

        //display the arguments to the method
        Object[] args = theJoinPoint.getArgs();

        //loop thru and display args
        for (Object tempArg : args) {
            myLogger.info("=====>>> argument: " + tempArg);
        }
    }

    // add @AfterReturning advice
    @AfterReturning(pointcut="forAppFlow()", returning="theResult")
    public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
        // display method we are returning from
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("\n=====>>> in @AfterReturning: from method " + theMethod);

        //display the arguments to the method
        Object[] args = theJoinPoint.getArgs();
    }
}
