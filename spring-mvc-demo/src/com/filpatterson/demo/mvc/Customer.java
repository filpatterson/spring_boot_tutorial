package com.filpatterson.demo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Customer {

	private String firstName;
	
	@NotNull(message="is required")
	@Size(min=1, message="no input detected")
//	@NotBlank(message="is required")	//	this annotation also protects from whitespaces
	private String lastName;
	
	//	using not null annotation makes required use of Integer, not int
	@NotNull(message="is required")
	@Min(value=0, message="must be greater than 0")
	@Max(value=10, message="must be less than 10")
	private Integer freePasses;
	
	//	pattern for getting only 5 digits or characters by postal code
	@Pattern(regexp="^[a-zA-Z0-9]{5}", message="only 5 characters or digits")
	private String postalCode;
	
	@CourseCode
	private String courseCode;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
}
