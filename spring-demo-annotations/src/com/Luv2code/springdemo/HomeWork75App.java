package com.Luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HomeWork75App {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context =
			new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach coach = context.getBean("boxCoach", Coach.class);
		System.out.println(coach.getDailyWorkOut());
		System.out.println(coach.getDailyFortune());
		
		context.close();
	}

}
