package com.Sushant.EcomApp.Ecommerce.App.CustomeAnotation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Past;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Constraint(validatedBy = AdultValidator.class)
@Past(message = "Date of birth must be in the past")
public @interface Adult {
    String message() default "User  must be 18 year or older and less then 90 year";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}