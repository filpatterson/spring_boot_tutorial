package com.filpatterson.demo.services;

import com.filpatterson.demo.interfaces.FortuneService;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "this is a very sad day";
	}

}
