package com.Luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	//create an array of strings
	private  String[] date = {
		"Beware of the wolf in the sheep`s clothing",
		"Diligence is the mother of good luck",
		"The journey is the reward"
	};
	@Override
	public String getFortune() {
		Random random = new Random();
		int index = random.nextInt(date.length);
		return date[index];
	}

}
