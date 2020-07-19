package com.filpatterson.demo.services;

import java.util.Random;

import org.springframework.stereotype.Component;

import com.filpatterson.demo.interfaces.FortuneService;

@Component
public class RandomFortuneService implements FortuneService {

	//	create array of strings
	private String[] arrayOfFortunes = {
			"here is some random stuff", 
			"here's another random stuff", 
			"well, it's completely random stuff"
	};
	
	//	adding random number generator
	private Random random = new Random();
	
	//	pick random fortune
	@Override
	public String getFortune() {
		return arrayOfFortunes[random.nextInt(this.arrayOfFortunes.length)];
	}

}
