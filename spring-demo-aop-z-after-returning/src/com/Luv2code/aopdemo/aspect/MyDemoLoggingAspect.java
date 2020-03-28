package com.Luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
	
	// add a new advice for @AfterReturning on the findAccounts method
	@AfterReturning(
			pointcut = "execution(* com.Luv2code.aopdemo.dao.AccountDAO.fiendAccounts(..))",
			returning = "result"
			)
	public void afterReturningFindAccountAdvice(
			JoinPoint theJoinPoint, List<Account> result) {
		//print out which method we are advising on
		System.out.println("\n========>>> Executing @AfterReturning method:"+theJoinPoint.getSignature().toShortString());
		
		//print the results of the method call
		System.out.println("========>>> Result of the method IN Aspect="+ result);
		
		//let`s post-process the data ... let`s modify it
		//convert the account names to uppercase
		convertAccountNamesToUpperCase(result);
		System.out.println("========>>> Result of the method OUT of Aspect="+ result);
	}

	private void convertAccountNamesToUpperCase(List<Account> result) {
		for (Account account : result) {
			account.setName(account.getName().toUpperCase());
		}
		
	}

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
