package com.filpatterson.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.filpatterson.demo.interfaces.Coach;
import com.filpatterson.demo.interfaces.FortuneService;

@Component
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("happyFortuneService")
	private FortuneService fortuneService;
	
	//	here is constructor injection, can be replaced by setter injection
//	@Autowired
//	TennisCoach(@Qualifier("happyFortuneService") FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}

	//	here is setter injection, can be replaced by field injection
//	TennisCoach() {
//	}
//	
//	@Autowired
//	public void setFortuneService(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}
	
	@Override
	public String getDailyWorkout() {
		return "this is new workout with annotations";
	}
	
	@Override
	public String getDailyFortune() {
		return this.fortuneService.getFortune();
	}
}
