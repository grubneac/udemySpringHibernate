package com.Luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyCloudLogAsyncAspect {
	@Before("com.Luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPacageNoGetterSetter()")		
	public void logToCloudAsync() {
		System.out.println("\n======>>>>@Order(3) Logging to Cloud in async fashion");
	}
	
}
