package com.Luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		// read spring config file
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get the bean from spring container
		Coach theCoach = context.getBean("swimCoach", Coach.class);
		
		//call a method on the bean
		System.out.println(theCoach.getDailyWorkOut());
		
		// call a method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		//get method to get values from property file
		System.out.println("email: "+theCoach.getEmail());
		System.out.println("team: "+theCoach.getTeam());
		
		//close the context
		context.close();

	}

}
