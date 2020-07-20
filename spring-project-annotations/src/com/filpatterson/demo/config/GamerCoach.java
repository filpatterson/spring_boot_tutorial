package com.filpatterson.demo.config;

import com.filpatterson.demo.interfaces.Coach;
import com.filpatterson.demo.interfaces.FortuneService;

public class GamerCoach implements Coach {

	private FortuneService fortuneService;
	
	GamerCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "work until my eyes are too tired to look at the screen";
	}

	@Override
	public String getDailyFortune() {
		return this.fortuneService.getFortune();
	}

}
