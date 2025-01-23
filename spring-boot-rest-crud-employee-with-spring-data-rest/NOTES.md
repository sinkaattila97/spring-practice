1. Set up Database Dev Environment
2. Create Spring Boot Project with spring Initializr
   - Update db config in application.properties
   - Create Employee Entity
   - Create DAO interface
   - Create DAO implementation
   - Create REST Controller to use DAO
3. Get list of employees
4. Get single employee by id
5. Add new employee
6. Update existing employee
7. Delete employee



## Notes:
>DAO: Handles direct interaction with the database. It performs CRUD operations and abstracts the data access logic.

>Service: Contains business logic and can call multiple DAOs to perform operations that require data from different sources.



## Spring Data REST
- For Spring Data REST, we only need 3 items
 1. My entity: Employee
 2. JpaRepository: EmployeeRepository extends JpaRepository<Employee, Integer>
 3. Maven POM dependency: spring-boot-starter-data-rest

- Spring Data REST automatically exposes REST endpoints for the entity
- It also provides HATEOAS support
- It also provides pagination and sorting support
- We just need to add an 's' (plural) to the entity name to get the REST endpoint
- Example: http://localhost:8080/employees
- we can also sort: http://localhost:8080/employees?sort=lastName,desc


## Service Layer - Best Practices:
- apply transactional boundaries at the service layer
- it is the service layer's responsibility to manage transactional boundaries
- For code implementation:
   - apply @Transactional on service methods
   - remove @Transactional from DAO methods if they exist
  