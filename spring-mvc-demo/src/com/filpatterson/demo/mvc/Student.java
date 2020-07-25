package com.filpatterson.demo.mvc;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Student {

	private String firstName;
	private String secondName;
	private String country;
	private String favoriteLanguage;
	
	private LinkedHashMap<String, String> countryOptions;
	private LinkedHashMap<String, String> languageOptions;
	
	public Student() {
		countryOptions = new LinkedHashMap<>();
		languageOptions = new LinkedHashMap<>();
		
		countryOptions.put("BR", "Brazil");
		countryOptions.put("GER", "Germany");
		countryOptions.put("MD", "Moldova");
		countryOptions.put("RU", "Russia");
		
		languageOptions.put("java", "Java");
		languageOptions.put("C#", "C#");
		languageOptions.put("php", "PHP");
		languageOptions.put("ruby", "Ruby");
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

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public LinkedHashMap<String, String> getLanguageOptions() {
		return languageOptions;
	}
}
