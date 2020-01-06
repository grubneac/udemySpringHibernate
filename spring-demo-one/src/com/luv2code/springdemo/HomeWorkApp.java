package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HomeWorkApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext content = new ClassPathXmlApplicationContext("homeWork-applicationContext.xml");
		
		BoxCoach boxCoach = content.getBean("myCoach",BoxCoach.class);
		
		System.out.println("1:"+boxCoach.getDailyFortune());
		System.out.println("2:"+boxCoach.getDailyWorkout());
		System.out.println("3:"+boxCoach.getEmailAddress());
		System.out.println("4:"+boxCoach.getTeam());
		System.out.println("5:"+boxCoach.getFortuneService());
		
		
		
		boxCoach.getClass();
		
		content.close();
		

	}

}
