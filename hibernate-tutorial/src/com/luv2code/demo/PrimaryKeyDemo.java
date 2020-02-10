package com.luv2code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().
											configure().
											addAnnotatedClass(Student.class).
											buildSessionFactory();
							
		Session session = factory.getCurrentSession();
		
		try{
		//create 3 students object
		Student st = new Student("firstName", "lastName", "email");
		Student st1 = new Student("firstName1", "lastName1", "email1");
		Student st2 = new Student("firstName2", "lastName2", "email2");
		
		//start transaction
		session.beginTransaction();
		
		//save the student
		session.save(st);
		session.save(st1);
		session.save(st2);
		
		//commit the transaction
		session.getTransaction().commit();
		
		}finally{
		factory.close();
		}		
		
	}

}
