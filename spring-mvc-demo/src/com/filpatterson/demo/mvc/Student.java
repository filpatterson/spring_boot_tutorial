package com.filpatterson.demo.mvc;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Student {

	private String firstName;
	private String secondName;
	private String country;
	
	private LinkedHashMap<String, String> countryOptions;
	
	public Student() {
		countryOptions = new LinkedHashMap<>();
		
		countryOptions.put("BR", "Brazil");
		countryOptions.put("GER", "Germany");
		countryOptions.put("MD", "Moldova");
		countryOptions.put("RU", "Russia");
	}

	//	generated getters, setters
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}	
}
