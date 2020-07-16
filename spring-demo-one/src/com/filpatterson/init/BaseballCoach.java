package com.filpatterson.init;

import com.filpatterson.init.interfaces.Coach;
import com.filpatterson.init.interfaces.FortuneService;

public class BaseballCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	public BaseballCoach() {}
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}
	
	@Override
	public String getDailyFortune() {
		return this.fortuneService.getFortune();	
	}
}
