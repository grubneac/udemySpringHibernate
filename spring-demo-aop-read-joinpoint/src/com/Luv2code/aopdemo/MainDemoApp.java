package com.Luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Luv2code.aopdemo.dao.AccountDAO;
import com.Luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
			AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
			MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		//call the buisnes method
		accountDAO.addAccount(new Account("Vasea","bigLevel"), true);
		
		//call the getter and setter
		accountDAO.setName("VaseaPecus");
		accountDAO.setServiceCode("serviceCode");
		String name = accountDAO.getName();
		String serviceCode = accountDAO.getServiceCode();
			
		membershipDAO.addAccountMemberShip();
		
		membershipDAO.goToSleep();
		
		//close the context
			context.close();
		
	}
}
