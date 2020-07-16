package com.filpatterson.init;

import java.util.Random;

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
