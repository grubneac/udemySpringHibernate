package com.luv2code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().
										configure().
										addAnnotatedClass(Instructor.class).
										addAnnotatedClass(InstructorDetail.class).
										addAnnotatedClass(Course.class).
										addAnnotatedClass(Review.class).
										buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{
			
			
			
			//start transaction
			session.beginTransaction();
			
			//create  a course
			Course course = new Course("Pacman - How To Scope One Million Points");
			
			//add some reviw
			course.addReview(new Review("Great course.... loved it!!"));
			course.addReview(new Review("Cool course, job well done"));
			course.addReview(new Review("What a dump course? you are an idiot!!"));
			
			//save the course and cascade revies
			session.save(course);
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}finally{
			session.close();
			factory.close();
		}		

	}

}
