package com.luv2code.springdemo;

public class MyApp {

	public static void main(String[] args) {
		// create the object
		Coach theCoach = new BasseballCoach(new HappyFortuneService());
		
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());

	}

}
