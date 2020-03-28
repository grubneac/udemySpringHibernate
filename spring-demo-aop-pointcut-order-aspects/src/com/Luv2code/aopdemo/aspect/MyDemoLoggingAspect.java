package com.Luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

	@Before("com.Luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPacageNoGetterSetter()")		
	public void beforeAddAccountAdvice() {
		System.out.println("\n======>>>>@Order(1) Execute @Before advice on method");
	}

	
}
