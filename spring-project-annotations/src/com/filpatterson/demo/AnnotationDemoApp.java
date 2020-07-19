package com.filpatterson.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		// read spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//	get the bean from container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		//	call method of the bean
		System.out.println(theCoach.getDailyWorkout());
		
		//	close context of application
		context.close();
	}

}
