package com.luv2code.springdemo;

public class BoxCoach implements Coach {

	private FortuneService fortuneService;
	private String emailAddress;
	private String team;

	//create a no-arg constructor
	public BoxCoach() {
		System.out.println("BoxCoach : inside no-arg constructor");
	}
	
	@Override
	public String getDailyWorkout() {
		
		return "BoxCoach.getDailyWorkout(): flutter like a butterfly sorry like a bee";
	}

	@Override
	public String getDailyFortune() {
		
		return "BoxCoach.getDailyFortune(): "+fortuneService.getFortune();
	}

	public FortuneService getFortuneService() {
		return fortuneService;
	}

	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}
	

}
