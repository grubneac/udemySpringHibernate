package com.Luv2code.aopdemo;



import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Luv2code.aopdemo.service.TrafficFortuneService;

public class AroundHandlrExceptionDemoApp {

	public static void main(String[] args) {
		
		final Logger myLogger= Logger.getLogger(AroundHandlrExceptionDemoApp.class.getName());
		
		
		//read spring config java class
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
			TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
	
			myLogger.info("\nMain Program: AroundDemoApp");
			
			myLogger.info("Callling getFortune");
			
			boolean tripWire = true;
			String data = theFortuneService.getFortune(tripWire);
			
			myLogger.info("\nMy fortune is: "+ data);
			
			myLogger.info("Finished");
			
		//close the context
			context.close();
		
	}
}
