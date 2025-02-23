## Adding AOP to an MVC CRUD JPA application

___Steps:___
1. We have a Web Browser which makes a call into Employee __Controller__
2. Goes over to the __Service__ (Employee Service)
3. Goes over to the __DAO__ (Data Access Object)
4. We get data from the database using JPA Hibernate
5. We send all back to a Thymeleaf page
6. We send back to the Web Browser as a html page

>CONTROLLER -> SERVICE -> DAO -> DATABASE

Now if we want to add __AOP__ (Aspect Oriented Programming) to this, we can add it to the __Service__ layer.

___Development process:___
1. Add Spring Boot AOP Starter to Maven pom
   2. Create Aspect
       1. Add logging support
       2. Setup pointcut declaration
       3. Add @Before

   >   We can see in the log the following: <br>
   >      =====>>> Executing @Before advice on method EmployeeController.listEmployees(..)  <br>
   >      =====>>> Executing @Before advice on method EmployeeServiceImpl.findAll()  <br>
   >     =====>>> Executing @Before advice on method EmployeeRepository.findAllByOrderByLastNameAsc()  <br><br>
   >      So listEmployees() method in the ___CONTROLLER___ is calling findAll() method in the ___SERVICE___, which is calling findAllByOrderByLastNameAsc() method in the ___DAO___ Repository.
   >       , @AfterReturning advice <br><Br> CONTROLLER -> SERVICE -> DAO -> DATABASE
   
   >   A basic update on the employees looks like this in the log: (pressing the update button from ___CONTROLLER___)<br>
   >   =====>>> Executing @Before advice on method CrudRepository.findById(..) <br>
   >   =====>>> argument: 1  (from ___SERVICE___)<br>
   >   =====>>> Executing @Before advice on method EmployeeController.saveEmployee(..) <br>
   >   =====>>> argument: Employee [id=1, firstName=Mike, lastName=Johnes, email=mikeyj@mail.com] <br>
   >   =====>>> Executing @Before advice on method EmployeeServiceImpl.save(..)   (save from ___SERVICE___)<br>
   >   =====>>> argument: Employee [id=1, firstName=Mike, lastName=Johnes, email=mikeyj@mail.com] <br>
   >   =====>>> Executing @Before advice on method CrudRepository.save(..) (save from ___DAO___)<br>
   >   =====>>> argument: Employee [id=1, firstName=Mike, lastName=Johnes, email=mikeyj@mail.com] <br>
   >   =====>>> Executing @Before advice on method EmployeeController.listEmployees(..) <br>
   >   =====>>> argument: {} ()list from ___CONTROLLER___<br>
   >   =====>>> Executing @Before advice on method EmployeeServiceImpl.findAll() <br>
   >   =====>>> Executing @Before advice on method EmployeeRepository.findAllByOrderByLastNameAsc() <br>

  4. Add @AfterReturning advice

Note: After adding the @AfterReturning: Controller returns the name of the html page, which is the same as the method name in the Controller. <br>
