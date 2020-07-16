package com.filpatterson.init;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHelloApp {

	public static void main(String[] args) {
		//	load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//	retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		//	use interface for casting object types
		Coach anotherCoach = context.getBean("anotherCoach", Coach.class);
		
		//	call methods of bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(anotherCoach.getDailyWorkout());
		
		//	calling injected dependencies services
		System.out.println(theCoach.getDailyFortune());
		System.out.println(anotherCoach.getDailyFortune());
		
		//	closing context
		context.close();
	}

}
