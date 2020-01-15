package com.Luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		//load spring config file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		//retrieve bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		//check if they are the same
		System.out.println("Compare couchs equals="+(theCoach==alphaCoach));
		
		System.out.println("\nMemory location for theCoach: " + theCoach);
		System.out.println("Memory location for alphaCoach: " + alphaCoach);
		
		//close context
		context.close();
	}

}
