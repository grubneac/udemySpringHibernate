package com.Luv2code.aopdemo;



import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Luv2code.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {

	public static void main(String[] args) {
		
		final Logger myLogger= Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
		
		
		//read spring config java class
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
			TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
	
			myLogger.info("\nMain Program: AroundDemoApp");
			
			myLogger.info("Callling getFortune");
			
			String data = theFortuneService.getFortune();
			
			myLogger.info("\nMy fortune is: "+ data);
			
			myLogger.info("Finished");
			
		//close the context
			context.close();
		
	}
}
