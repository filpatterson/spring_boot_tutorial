package com.filpatterson.demo.mvc;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


//	requires implementation of two methods initialize() and isValid(). Second method is from
// Spring MVC for checking validation result.
public class CourseCodeConstraintValidator implements ConstraintValidator <CourseCode, String> {

	private String[] coursePrefix;
	
	@Override
	public void initialize(CourseCode courseCode) {
		coursePrefix = courseCode.value();
	}
	
	@Override
	public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {
		if(code != null) 
			for(int i = 0; i < coursePrefix.length; i++) 
				if(code.startsWith(coursePrefix[i]))
					return true;
		
		return false;
	}
}
