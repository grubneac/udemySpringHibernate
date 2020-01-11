package com.Luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoxCoach implements Coach {

	private FortuneService fortuneService;
	
	@Autowired
	public BoxCoach(FortuneService fortuneService) {
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
}
