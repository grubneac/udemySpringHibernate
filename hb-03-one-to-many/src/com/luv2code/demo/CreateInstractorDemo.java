package com.luv2code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateInstractorDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().
										configure().
										addAnnotatedClass(Instructor.class).
										addAnnotatedClass(InstructorDetail.class).
										addAnnotatedClass(Course.class).
										buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{
			
			
			
			//start transaction
			session.beginTransaction();
			
			Instructor instructor = session.get(Instructor.class, 1);
						
			Course course1 = new  Course("Air Guitar");
			Course course2 = new  Course("The Pinball Masterclass");
			
			instructor.add(course1);
			instructor.add(course2);
			
			
			//save couses with out instructor
			session.save(course1);
			session.save(course2);
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}finally{
			session.close();
			factory.close();
		}		

	}

}
