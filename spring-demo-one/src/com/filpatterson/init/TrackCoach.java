package com.filpatterson.init;

import com.filpatterson.init.interfaces.Coach;
import com.filpatterson.init.interfaces.FortuneService;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	public TrackCoach() {}
	
	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return this.fortuneService.getFortune();	
	}
	
	//	adding init and destroy methods
	
	public void doStartUp() {
		System.out.println("this is init method call");
	}
	
	public void doDestroy() {
		System.out.println("do cleaning method for killing");
	}
}
