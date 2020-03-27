package com.Luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public void addAccountMemberShip() {
		System.out.println(getClass() + "DOING MY DB WORK: ADDING AN MEMBERSHIP ACCOUNT");
	}
	public void goToSleep() {
		System.out.println(getClass() + "I am going to sleep now");
	}
}
