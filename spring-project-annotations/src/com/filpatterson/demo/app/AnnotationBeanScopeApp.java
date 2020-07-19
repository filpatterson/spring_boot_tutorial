package com.filpatterson.demo.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.filpatterson.demo.interfaces.Coach;

public class AnnotationBeanScopeApp {

	public static void main(String[] args) {
		//	read context from the file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//	retrieve bean from the container
		Coach theCoach = context.getBean("cricketCoach", Coach.class);
		Coach anotherCoach = context.getBean("cricketCoach", Coach.class);
		Coach firstTennisCoach = context.getBean("tennisCoach", Coach.class);
		Coach secondTennisCoach = context.getBean("tennisCoach", Coach.class);
		
		//	print info about objects
		System.out.println(theCoach);
		System.out.println(anotherCoach);
		System.out.println(firstTennisCoach);
		System.out.println(secondTennisCoach);
		
		if(theCoach == anotherCoach)
			System.out.println("cricket coaches are the one coach!");
		else
			System.out.println("cricket coaches are different");
		
		if(firstTennisCoach == secondTennisCoach)
			System.out.println("tennis coaches are referencing to the single one");
		else
			System.out.println("those are different tennis coaches");
		
		//	close container
		context.close();
	}

}
