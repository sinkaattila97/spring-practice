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


## Service Layer - Best Practices:
- apply transactional boundaries at the service layer
- it is the service layer's responsibility to manage transactional boundaries
- For code implementation:
   - apply @Transactional on service methods
   - remove @Transactional from DAO methods if they exist
  