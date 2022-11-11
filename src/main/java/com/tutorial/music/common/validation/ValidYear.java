package com.tutorial.music.common.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Min(1800)
@Max(2199)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Constraint(validatedBy = {})
@Documented
public @interface ValidYear {

    String message() default "Invalid year";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
