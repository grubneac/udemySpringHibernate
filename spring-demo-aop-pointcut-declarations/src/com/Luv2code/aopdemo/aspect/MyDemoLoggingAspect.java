package com.Luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	@Pointcut("execution(public void com.Luv2code.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {} 
	
	@Before("forDaoPackage()")		//all methods in package with any arguments
	public void beforeAddAccountAdvice() {
		System.out.println("======>>>> Execute @Before advice on method");
	}
	@After("forDaoPackage()")		//all methods in package with any arguments
	public void performApiAnalytics() {
		System.out.println("======>>>> Execute Performing API analytics\n");
	}
}
