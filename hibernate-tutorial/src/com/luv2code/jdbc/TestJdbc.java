package com.luv2code.jdbc;

import java.sql.*;



public class TestJdbc {

	public static void main(String[] args) {
		String  jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=Europe/Bucharest";
		String user ="hbstudent";
		String pass ="hbstudent";
		
		try {
			System.out.println("Connection to database: "+jdbcUrl);
			
			Connection myConn=
					DriverManager.getConnection(jdbcUrl,user,pass);
			
			System.out.println("Connection successeful !!!");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
