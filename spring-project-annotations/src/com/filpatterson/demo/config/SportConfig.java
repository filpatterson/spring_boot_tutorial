package com.filpatterson.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.filpatterson.demo.SwimCoach;
import com.filpatterson.demo.interfaces.Coach;
import com.filpatterson.demo.interfaces.FortuneService;
import com.filpatterson.demo.services.SadFortuneService;

@Configuration
//@ComponentScan("com.filpatterson.demo")
@PropertySource("classpath:fortuneService.properties")
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
	
	@Bean
	public Coach gamerCoach() {
		return new GamerCoach(sadFortuneService());
	}
}
