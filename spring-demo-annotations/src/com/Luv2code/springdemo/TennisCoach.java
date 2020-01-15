package com.Luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TennisCoach implements Coach {

	@Value("${foo.email}")
	private String email;
	    
	@Value("${foo.team}")
	private String team;
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	//define the default constructor
	public TennisCoach() {
		System.out.println(">>TennisCoach: inside the default constructor");
	}

	/*
	 * @Autowired public void myOwnMethodForSetFortuneService(FortuneService
	 * fortuneService) { System.out.
	 * println(">>TennisCoach: inside myOwnMethodForSetFortuneService() method");
	 * this.fortuneService = fortuneService; }
	 */

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
	@Override
	public String getEmail() {
		return email;
	}
	@Override
	public String getTeam() {
		return team;
	}
	

}
