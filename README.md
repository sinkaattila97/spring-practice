Key features:
- Spring Boot Core features
- JAP/Hibernate .. including @OneToOne, @OneToMany, @OneToMany, @ManyToMany
- Spring Boot REST CRUD API
- Spring MVC CRUD WebApp
- Spring Security

## Notes:
>DAO: Handles direct interaction with the database. It performs CRUD operations and abstracts the data access logic.

>Service: Contains business logic and can call multiple DAOs to perform operations that require data from different sources.


## Service Layer - Best Practices:
- apply transactional boundaries at the service layer
- it is the service layer's responsibility to manage transactional boundaries
- For code implementation:
   - apply @Transactional on service methods
   - remove @Transactional from DAO methods if they exist
