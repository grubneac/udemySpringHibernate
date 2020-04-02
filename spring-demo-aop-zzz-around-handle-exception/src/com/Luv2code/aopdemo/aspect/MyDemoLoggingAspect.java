package com.Luv2code.aopdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	final Logger myLogger= Logger.getLogger(MyDemoLoggingAspect.class.getName());
	
	@Around("execution(* com.Luv2code.aopdemo.service.TrafficFortuneService.getFortune(..))")
	public Object arroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint)throws Throwable {
		
		//print out method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n====================>Executing @Arround on method: "+method);
		
		//get begin timestamp
		long begin = System.currentTimeMillis();
		
		//now let`s execute the method
		Object result = null;
		try {
			result = theProceedingJoinPoint.proceed();
		}catch(Exception ex) {
			//log the exception
			myLogger.warning(ex.getMessage());
			
			//rethrow the exception
			throw ex;
		}
		
		//get end timestamp
		long end = System.currentTimeMillis();
		
		//compute duration and display it
		myLogger.info("\n Duration "+(end-begin)/1000.0 + "seconds");
		
		return result;		
	}
		
}
