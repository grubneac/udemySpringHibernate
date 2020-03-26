package com.Luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	//this is where we add all of our related advices for logging
	
	//let`s start with an @Before advice
//	@Before("execution(public void add*())")		//0 parameters
//	@Before("execution(public void add*(com.Luv2code.aopdemo.Account))")		//one special type of argument
//	@Before("execution(public void add*(*))")		// 1-argument of any type
//	@Before("execution(public void add*(com.Luv2code.aopdemo.Account..))")//one special type of argument and more arguments of any type
//	@Before("execution(public void add*(..))")		//0 or more arguments of any type
	@Before("execution(public void com.Luv2code.aopdemo.dao.*.*(..))")		//all methods in package with any arguments
	public void beforeAddAccountAdvice() {
		System.out.println("\n======>>>> Execute @Before advice on addAccount()");
	}
}
