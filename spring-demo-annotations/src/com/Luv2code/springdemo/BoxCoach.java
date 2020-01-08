package com.Luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class BoxCoach implements Coach {

	@Override
	public String getDailyWorkOut() {
		return "fluttering like a butterfly, sorry like a bee";
	}

}
