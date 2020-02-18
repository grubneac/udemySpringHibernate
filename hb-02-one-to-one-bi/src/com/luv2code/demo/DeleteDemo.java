package com.luv2code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().
										configure().
										addAnnotatedClass(Instructor.class).
										addAnnotatedClass(InstructorDetail.class).
										buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{
		
			//start transaction
			session.beginTransaction();
			
			Instructor instructor = session.get(Instructor.class, 1);
			System.out.println("Find instracor "+ instructor);
			//delete the student
			if(instructor != null)
				session.delete(instructor);
			
			//commit the transaction
			session.getTransaction().commit();
			
		}finally{
			factory.close();
		}		

	}

}
