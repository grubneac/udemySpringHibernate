package com.Luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.Luv2code.aopdemo.Account;
import com.Luv2code.aopdemo.AroundWithLoggerDemoApp;

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
		Object result = theProceedingJoinPoint.proceed();
		
		//get end timestamp
		long end = System.currentTimeMillis();
		
		//compute duration and display it
		myLogger.info("\n Duration "+(end-begin)/1000.0 + "seconds");
		
		return result;		
	}
		
}
