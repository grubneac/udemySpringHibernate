package com.luv2code.demo;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

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
			
			Query<Instructor> query = 
					session.createQuery("select i from Instructor i "
										+ "JOIN FETCH i.courses "
										+ "where i.id=:theInstuctorId"
										,Instructor.class);
			//set up parameters for query
			query.setParameter("theInstuctorId", 1);
			//execute query
			Instructor instructor = query.getSingleResult();
			System.out.println("instructor "+instructor);
			
			
			//commit the transaction
			session.getTransaction().commit();
			session.close();
			System.out.println("The session is now close\n");
			
			System.out.println("Courses: "+instructor.getCourses());
			
			System.out.println("Done!");
		}finally{
			session.close();
			factory.close();
		}		

	}

}
