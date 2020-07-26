package com.filpatterson.demo.mvc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/*some notes to this interface:
 * 	This is the base syntax for defining new annotation in java. For creation of new annotation
 * is used @interface. From the top are additional annotations to define properties of new annotation.
 * 	@Constraint tells which class contains business logic of current annotation.
 * 	@Target show where annotation can be used. In this case annotation can be used on methods and fields.
 * 	@Retention show how long annotation is retained in java. In current scenario it's retained for runtime.
 * 	groups provide info about constraints and payload shows validation failure details
 */

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target( {ElementType.METHOD, ElementType.FIELD} )
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
	//	default course code
	public String value() default "FIL";
	
	//	default error message
	public String message() default "must start with FIL";
	
	//	define default groups with information about constraints
	public Class<?>[] groups() default {};
	
	//	define default payload with information about validation error
	public Class<? extends Payload>[] payload() default {};
}
