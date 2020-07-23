package com.filpatterson.demo.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.filpatterson.demo.SwimCoach;
import com.filpatterson.demo.config.SportConfig;
import com.filpatterson.demo.interfaces.Coach;

public class AnnotationDemoNoXmlApp {

	public static void main(String[] args) {
		//	read context from the class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfig.class);
		
//		//	retrieve bean from the container
//		//	prototypes
//		Coach theCoach = context.getBean("cricketCoach", Coach.class);
//		Coach anotherCoach = context.getBean("cricketCoach", Coach.class);
//		//	singletons
//		Coach firstTennisCoach = context.getBean("tennisCoach", Coach.class);
//		Coach secondTennisCoach = context.getBean("tennisCoach", Coach.class);
		
//		//	print info about objects
//		//	prototypes
//		System.out.println(theCoach);
//		System.out.println(anotherCoach);
//		//	singletons
//		System.out.println(firstTennisCoach);
//		System.out.println(secondTennisCoach);
		
//		if(theCoach == anotherCoach)
//			System.out.println("cricket coaches are the one coach!");
//		else
//			System.out.println("cricket coaches are different");
//		
//		if(firstTennisCoach == secondTennisCoach)
//			System.out.println("tennis coaches are referencing to the single one");
//		else
//			System.out.println("those are different tennis coaches");
//		
//		context.getBeanFactory().destroyBean(theCoach);
//		context.getBeanFactory().destroyBean(anotherCoach);
//		
//		context.getBeanFactory().destroySingletons();
		
		SwimCoach swimmingCoach = context.getBean("swimCoach", SwimCoach.class);
		System.out.println(swimmingCoach.getDailyFortune());
		System.out.println(swimmingCoach.getDailyWorkout());
		System.out.println(swimmingCoach.getEmail());
		System.out.println(swimmingCoach.getTeam());
		
		System.out.println("--------------------------------------\n\n");
		
		Coach gamerCoach = context.getBean("gamerCoach", Coach.class);
		System.out.println(gamerCoach.getDailyFortune());
		System.out.println(gamerCoach.getDailyWorkout());
		
		//	close container
		context.close();
	}

}
