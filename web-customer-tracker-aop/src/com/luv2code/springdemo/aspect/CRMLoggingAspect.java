package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	//setup logger
	private static Logger myLogger =Logger.getLogger(CRMLoggingAspect.class.getName());
	
	//setup pointcut declarations
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	private void forControllerPakage(){}

	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	private void forServicePakage(){}

	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void forDaoPakage(){}
	
	@Pointcut("forControllerPakage() || forServicePakage() || forDaoPakage()")
	private void forAppFlow() {}
	
	//add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint){
		
		//display method we are calling
		myLogger.info("=====> in @Before calling method :" + theJoinPoint.getSignature().toShortString());
		
		//display the arguments to the method
		myLogger.info("====> in @Before method args:");
		Object[] args =theJoinPoint.getArgs();
		for (Object object : args) {
			myLogger.info("=====>"+object.toString());
		}
		
	}
	
	//add @AfterReturning advice
	
	@AfterReturning(pointcut = "forAppFlow()", returning = "theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult){
		
		//display method we are returning
		myLogger.info("=====> in @AfterReturning calling method :" + theJoinPoint.getSignature().toShortString());		
		
		//display data returned
		myLogger.info("=====> result: "+theResult);
		
	}
	
}
