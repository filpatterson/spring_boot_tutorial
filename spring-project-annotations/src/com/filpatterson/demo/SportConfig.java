package com.filpatterson.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.filpatterson.demo.interfaces.Coach;
import com.filpatterson.demo.interfaces.FortuneService;
import com.filpatterson.demo.services.SadFortuneService;

@Configuration
@ComponentScan("com.filpatterson.demo")
public class SportConfig {
	//	define simple bean
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	//	define bean and set dependency inside
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
}
