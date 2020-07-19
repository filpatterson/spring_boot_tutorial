package com.filpatterson.demo.services;

import org.springframework.stereotype.Component;

import com.filpatterson.demo.interfaces.FortuneService;

@Component
public class RestFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "here is rest service fortune!";
	}

}
