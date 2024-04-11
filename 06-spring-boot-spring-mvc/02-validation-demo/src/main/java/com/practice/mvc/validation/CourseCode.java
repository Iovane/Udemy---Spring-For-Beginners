package com.practice.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    // define default course code
    public String value() default "EXP";

    // define default error message
    public String message() default "must start with EXP";

    // define default groups
    public Class<?>[] groups() default {};

    // define default payloads
    public Class<? extends Payload>[] payload() default {};

}
