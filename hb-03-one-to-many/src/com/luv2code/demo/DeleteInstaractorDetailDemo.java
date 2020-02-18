package com.luv2code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteInstaractorDetailDemo {

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
			
			InstructorDetail instructorDetail =
					session.get(InstructorDetail.class, 4);
			System.out.println("instructorDetail "+instructorDetail);
			System.out.println("instractor "+instructorDetail.getInstructor());
			
			//remove the associated object reference
			instructorDetail.getInstructor().setInstructorDetail(null);
			
			session.delete(instructorDetail);
			//commit the transaction
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			factory.close();
		}		

	}

}