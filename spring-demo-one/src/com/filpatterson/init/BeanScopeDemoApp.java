package com.filpatterson.init;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		//	load spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		//	retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach secondCoach = context.getBean("myCoach", Coach.class);
		
		
		//	in default container scope is set as singleton, so container provides reference to the same object.
		//	in "prototype" container scope each call to the container will produce new object
		if(theCoach == secondCoach)
			System.out.println("they're the same object");
		else
			System.out.println("no, they're different objects");
		
		System.out.println("memory location of first: " + theCoach);
		System.out.println("memory location of second: " + secondCoach);
		
		context.close();
	}

}
