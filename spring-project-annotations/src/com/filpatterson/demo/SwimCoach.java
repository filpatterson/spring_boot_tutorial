package com.filpatterson.demo;

import com.filpatterson.demo.interfaces.Coach;
import com.filpatterson.demo.interfaces.FortuneService;

public class SwimCoach implements Coach {
	
	private FortuneService fortuneService;
	
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

}
