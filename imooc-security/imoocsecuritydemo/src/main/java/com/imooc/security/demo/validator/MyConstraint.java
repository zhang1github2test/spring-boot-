package com.imooc.security.demo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * zhshl  2018/9/16
 */
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MyconstraintValidator.class)
public @interface MyConstraint {
    String message() default "{com.imooc.security.demo.validator.MyConstraint.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
