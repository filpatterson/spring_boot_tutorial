package com.filpatterson.init.services;

import java.util.Random;

import com.filpatterson.init.interfaces.FortuneService;

public class HappyFortuneService implements FortuneService {
	
	private String[] arrayOfGreetings = {"hello, this is the first greeting!",
			"well, you reached second greeting",
			"ok, this is the last one"};
	
	private Random random = new Random();
	
	@Override
	public String getFortune() {
		return arrayOfGreetings[random.nextInt(3)];
	}
}
