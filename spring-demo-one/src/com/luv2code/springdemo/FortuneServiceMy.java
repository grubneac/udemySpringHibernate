package com.luv2code.springdemo;

import java.util.Random;

public class FortuneServiceMy implements FortuneService {

	private static String arrayFortune[]={"Fortune 1", "Fortune 2","Fortune 3"};
	@Override
	public String getFortune() {
		Random random = new Random();
		int ind = random.nextInt(arrayFortune.length);
		
		return arrayFortune[ind];
	}

}
