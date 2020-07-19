package com.filpatterson.demo.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.filpatterson.demo.interfaces.Coach;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		// read spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//	get the bean from container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach cricketCoach = context.getBean("cricketCoach", Coach.class);
		
		//	call method of the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(cricketCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		System.out.println(cricketCoach.getDailyFortune());
		
		//	close context of application
		context.close();
	}

}
