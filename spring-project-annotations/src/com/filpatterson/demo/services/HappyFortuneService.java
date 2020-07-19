package com.filpatterson.demo.services;

import org.springframework.stereotype.Component;

import com.filpatterson.demo.interfaces.FortuneService;

@Component
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "this is happy fortune!";
	}

}
