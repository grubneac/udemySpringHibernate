package com.Luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BoxCoach implements Coach {

	private FortuneService fortuneService;
	
	public BoxCoach() {
		System.out.println(">>BoxCoach: inside the default constructor");
	}
	
	@Autowired
	public BoxCoach(@Qualifier("fileFortuneService")FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	@Override
	public String getDailyWorkOut() {
		return "fluttering like a butterfly, sorry like a bee";
	}
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	@Override
	public String getEmail() {
		return null;
	}

	@Override
	public String getTeam() {
		return null;
	}
}
