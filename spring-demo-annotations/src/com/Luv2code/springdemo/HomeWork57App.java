package com.Luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HomeWork57App {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context =
			new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach coach = context.getBean("boxCoach", Coach.class);
		System.out.println(coach.getDailyWorkOut());
		
		context.close();
	}

}
