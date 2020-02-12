package com.luv2code.demo;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		BasicConfigurator.configure();
		SessionFactory factory = new Configuration().
										configure().
										addAnnotatedClass(Student.class).
										buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{
			//create a student object
			Student st = new Student("firstName", "lastName", "email");
			
			//start transaction
			session.beginTransaction();
			
			//save the student
			session.save(st);
			
			//commit the transaction
			session.getTransaction().commit();
			
		}finally{
			factory.close();
		}		

	}

}
