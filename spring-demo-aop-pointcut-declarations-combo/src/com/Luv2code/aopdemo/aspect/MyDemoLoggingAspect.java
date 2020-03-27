package com.Luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	@Pointcut("execution( * com.Luv2code.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {} 
	
	//create point cut for getter method
	@Pointcut("execution( * com.Luv2code.aopdemo.dao.*.get*(..))")
	private void forGettterMethod() {} 
	
	//create point cut for setter method
	@Pointcut("execution( * com.Luv2code.aopdemo.dao.*.set*(..))")
	private void forSettterMethod() {} 
	
	//create pointcut: include package and exclude setter/getter
	@Pointcut("forDaoPackage() && !(forGettterMethod() || forSettterMethod())")
	private void forDaoPacageNoGetterSetter() {}
	
	@Before("forDaoPacageNoGetterSetter()")		//all methods in package without getter and setter methods
	public void beforeCombinePointCut() {
		System.out.println("======>>>> Execute @Before CombinePointCut()");
	}
	@Before("forDaoPackage()")		//all methods in package with any arguments
	public void beforeAddAccountAdvice() {
		System.out.println("======>>>> Execute @Before advice on method");
	}
	@After("forDaoPackage()")		//all methods in package with any arguments
	public void performApiAnalytics() {
		System.out.println("======>>>> Execute @After advice on method\n");
	}

	
}
