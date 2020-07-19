package com.filpatterson.demo.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.filpatterson.demo.interfaces.FortuneService;

@Component
public class RandomFortuneService implements FortuneService {

	@Value("${fortune.first}")
	private String firstFortune;
	
	@Value("${fortune.second}")
	private String secondFortune;
	
	@Value("${fortune.third}")
	private String thirdFortune;
	
	//	adding random number generator
	private Random random = new Random();
	
	//	pick random fortune
	@Override
	public String getFortune() {
		switch(random.nextInt(3)) {
			case 0:
				return this.firstFortune;
			case 1:
				return this.secondFortune;
			case 2:
				return this.thirdFortune;
			default:
				return "error!";
		}
	}

}
