package com.codingdojo.gotnxt.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PresentOrFutureDateValidator.class)
@Documented
public @interface DatePresentOrFuture {
	String message() default "Time travelilng to the Past is Not Allowed.";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
