package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScoupeDemoApp {

	public static void main(String[] args) {
		//load the spring configuration file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		//retrieve bean from dpring container
		Coach theCoach = context.getBean("myCoach", Coach.class);

		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		//check if they are the same
		System.out.println("\nPoint to the same object:"+(theCoach==alphaCoach));
		
		System.out.println("Memory location for theCoach: "+theCoach);
		System.out.println("Memory location for alphaCoach: "+alphaCoach);
		
		
		//close the context
		context.close();
	}

}
