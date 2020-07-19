package com.filpatterson.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.filpatterson.demo.interfaces.Coach;
import com.filpatterson.demo.interfaces.FortuneService;

@Component
public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	@Autowired
	CricketCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "today I worked 30 minutes with cricket, it's not so much fun!";
	}
	
	@Override
	public String getDailyFortune() {
		return this.fortuneService.getFortune();
	}
}
