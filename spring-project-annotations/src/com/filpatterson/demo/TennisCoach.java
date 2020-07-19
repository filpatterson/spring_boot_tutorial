package com.filpatterson.demo;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "this is new workout with annotations";
	}
}
