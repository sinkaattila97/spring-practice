# Notes

 In Thymeleaf, the th:object and th:field attributes are used to bind form fields to a model object. Here's the explanation:
> __th:object:__
The th:object attribute is used to specify the model attribute that the form is bound to.
It uses the ${} syntax to reference the model attribute, which in this case is customer.
This tells Thymeleaf that the form fields inside this form are bound to the customer object.
- th:object
  The th:object attribute is used to specify the model attribute that the form is bound to.
  It uses the ${} syntax to reference the model attribute, which in this case is customer.
  This tells Thymeleaf that the form fields inside this form are bound to the customer object.

> __th:field:__
The th:field attribute is used to bind a specific form field to a property of the model object specified by th:object.
It uses the *{} syntax to reference the property of the model object.
The *{} syntax is a shorthand that tells Thymeleaf to look for the property within the object specified by th:object.In Thymeleaf, the th:object and th:field attributes are used to bind form fields to a model object.

- th:field
The th:field attribute is used to bind a specific form field to a property of the model object specified by th:object.
It uses the *{} syntax to reference the property of the model object.
The *{} syntax is a shorthand that tells Thymeleaf to look for the property within the object specified by th:object.

* @InitBinder 
   - pre-processes all the request, every String form data
   - Removes leadin and training white spaces
   - If String has only white spaces, trims it to null

### Create a @PostalCode annotation
- Usage:
```java
@PostalCode(value="CLJ", message="Postal code must start with CLJ")

private String postalCode;
```
- Create a custom validator

```java
import jakarta.validation.Constraint;

@Constraint(validatedBy = PostalCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
private @interface PostalCode;
```
-Explanation:
  - @interface: This annotation is used to declare a new annotation. In this case, the PostalCode annotation is declared.
  - @Constraint: This annotation is used to specify the class that will validate the constraint. In this case, the PostalCodeConstraintValidator class will validate the PostalCode constraint.
  - @Target: This annotation is used to specify where the constraint can be applied. In this case, the constraint can be applied to methods and fields.
  - @Retention: This annotation is used to specify when the annotation is available. In this case, the annotation is available at runtime.
