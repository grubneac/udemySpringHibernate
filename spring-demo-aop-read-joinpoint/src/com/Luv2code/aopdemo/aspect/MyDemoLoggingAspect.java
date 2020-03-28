package com.Luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.Luv2code.aopdemo.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

	@Before("com.Luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPacageNoGetterSetter()")		
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n======>>>>@Order(1) Execute @Before advice on method");
		
		//display the metod signature
		MethodSignature methodSign = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: " + methodSign);
		
		//display method arguments
		//get args
		Object[] obj = theJoinPoint.getArgs(); 
		//loop thru args
		int i=0;
		for (Object object : obj) {
			if(object instanceof Account) {
				Account theAccount =(Account)object;
				System.out.println("Account name: "+theAccount.getName()+" ; Account level: "+theAccount.getLevel());
			}else
				System.out.println("Argument("+i++ +"): "+object.toString());
				
		}
		
	}

	
}
