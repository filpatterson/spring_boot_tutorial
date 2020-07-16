package com.filpatterson.init.apps;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.filpatterson.init.interfaces.Coach;

public class BeanLifecycleDemoApp {

	public static void main(String[] args) {
		//	load spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
		
		//	retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach secondCoach = context.getBean("cricketCoach", Coach.class);
		
		//	program calls destroy methods when container is closed, but it doesn't call those methods if bean
		// scope was declared as "prototype". For making such bean destroyable must be created custom destroy()
		// for such object and set implements for DisposableBean class. The last step is to set your own bean 
		// factory for processing elements
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(secondCoach.getDailyWorkout());
		
		context.close();
	}

}
