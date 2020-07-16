package com.filpatterson.init;

import com.filpatterson.init.interfaces.Coach;
import com.filpatterson.init.interfaces.FortuneService;

public class CricketCoach implements Coach{
	
	//	class fields
	private FortuneService fortuneService;
	private String emailAddress;
	private String team;
	
	
	//	class contructors
	CricketCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	CricketCoach() {}
	
	
	//	class getters and setters
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
		System.out.println("Spring is setting fortune service using already made happy fortune service");
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getEmailAddress() {
		return this.emailAddress;
	}
	
	public void setTeam(String team) {
		this.team = team;
	}
	
	public String getTeam() {
		return this.team;
	}
	
	
	//	overriding interfaces
	@Override
	public String getDailyWorkout() {
		return "Working 1h on cricket, its boring";
	}
	
	@Override
	public String getDailyFortune() {
		return "The only thing that i'm thinking about: " + this.fortuneService.getFortune();	
	}
	
	public String toString() {
		return "This is Cricket Coach. His email: " + this.emailAddress + "; his team: " + this.team + ";";
	}
}
