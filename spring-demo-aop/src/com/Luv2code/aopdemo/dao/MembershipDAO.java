package com.Luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public void addAccount() {
		System.out.println(getClass() + "DOING MY DB WORK: ADDING AN MEMBERSHIP ACCOUNT");
	}
}
