package com.filpatterson.demo;

import org.springframework.beans.factory.annotation.Value;

import com.filpatterson.demo.interfaces.Coach;
import com.filpatterson.demo.interfaces.FortuneService;

public class SwimCoach implements Coach {
	
	private FortuneService fortuneService;
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	public SwimCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "my workout takes 1-2 hours per day. it's awesome!";
	}

	@Override
	public String getDailyFortune() {
		return this.fortuneService.getFortune();
	}

	//	general getters and setters
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}
	
	

}
