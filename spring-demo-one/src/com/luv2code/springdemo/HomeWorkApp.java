package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HomeWorkApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext content = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		BoxCoach boxCoach = content.getBean("myBoxCoach",BoxCoach.class);
		
		System.out.println(boxCoach.getDailyFortune());
		System.out.println(boxCoach.getDailyWorkout());
		System.out.println(boxCoach.getEmailAddress());
		System.out.println(boxCoach.getTeam());
		System.out.println(boxCoach.getFortuneService());
		
		
		
		boxCoach.getClass();
		

	}

}
