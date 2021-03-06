package com.filpatterson.demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.filpatterson.demo.interfaces.Coach;
import com.filpatterson.demo.interfaces.FortuneService;

@Component
@Scope("prototype")
public class CricketCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	//	constructor injection, can be replaced by setter injection
//	@Autowired
//	CricketCoach(@Qualifier("randomFortuneService") FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}
	
	//	setter injection, can be replaced by field injection
//	CricketCoach() {
//	}
//	
//	@Autowired
//	public void setFortuneService(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}
	
	@PostConstruct
	public void doStartUpActions() {
		System.out.println("here is startup for cricket coach");
	}
	
	@PreDestroy
	public void doCleanUpActions() {
		System.out.println("here is clean up of cricket coach when it shuts down");
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
