package com.Luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component("tttt")
public class RESTFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "return RESTFortuneService.getFortune()";
	}

}
