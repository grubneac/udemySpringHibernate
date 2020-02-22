package com.luv2code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().
										configure().
										addAnnotatedClass(Instructor.class).
										addAnnotatedClass(InstructorDetail.class).
										buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{
			//create a Instructor object
			Instructor instructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
			
			InstructorDetail instructorDetail = new InstructorDetail("luv2code.com/youTube ", "Luv 2 code!!");
			instructor.setInstructorDetail(instructorDetail);
			
			//start transaction
			session.beginTransaction();
			
			//save the student
			session.save(instructor);
			
			//commit the transaction
			session.getTransaction().commit();
			
		}finally{
			factory.close();
		}		

	}

}
