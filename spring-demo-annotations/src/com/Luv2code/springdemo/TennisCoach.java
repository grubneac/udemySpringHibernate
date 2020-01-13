package com.Luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	private FortuneService fortuneService;
	
	//define the default constructor
	public TennisCoach() {
		System.out.println(">>TennisCoach: inside the default constructor");
	}

	@Autowired
	public void myOwnMethodForSetFortuneService(FortuneService fortuneService) {
		System.out.println(">>TennisCoach: inside myOwnMethodForSetFortuneService() method");
		this.fortuneService = fortuneService;
	}

	/*
	 * @Autowired public TennisCoach(FortuneService fortuneService) {
	 * this.fortuneService = fortuneService; }
	 */

	@Override
	public String getDailyWorkOut() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
