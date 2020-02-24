package com.luv2code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class DeletePacmanCourseDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().
										configure().
										addAnnotatedClass(Instructor.class).
										addAnnotatedClass(InstructorDetail.class).
										addAnnotatedClass(Course.class).
										addAnnotatedClass(Review.class).
										addAnnotatedClass(Student.class).
										buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{
			
			
			
			//start transaction
			session.beginTransaction();
			
			//get course
			Course thePacman =session.get(Course.class, 10);
			
			System.out.println("Deleting the course "+thePacman.getTitle());
			session.delete(thePacman);
			
				//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}finally{
			session.close();
			factory.close();
		}		

	}

}
