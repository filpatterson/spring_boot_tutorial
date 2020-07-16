package com.filpatterson.init;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		//	load spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//	retrieve bean from spring container
		/*
		 * Important note here
		 * 	here is used cricket coach class, because it's the only class that has access to the getters and setters
		 * of team and email. using base interface will give access only to the methods that are defined in interface,
		 * so we're limited by interface methods and only them.
		*/
		CricketCoach cricketCoach = context.getBean("cricketCoach", CricketCoach.class);
		
		//	call methods of the bean
		System.out.println(cricketCoach.getDailyFortune());
		System.out.println(cricketCoach.getDailyWorkout());
		System.out.println(cricketCoach);
		
		//	close the context
		context.close();
	}

}
