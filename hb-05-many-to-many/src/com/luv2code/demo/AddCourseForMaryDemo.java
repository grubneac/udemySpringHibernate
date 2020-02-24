package com.luv2code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class AddCourseForMaryDemo {

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
			
			//get mary from database
			Student theMary =session.get(Student.class, 2);
			System.out.println("\nMary "+theMary);
			System.out.println("Mary courses "+theMary.getCourses());
			
			//create more courses
			Course course1 = new Course("Rubik`s Cube - How to Speed Cube");
			Course course2 = new Course("Atari 260 - Game Development");
			
			//add student to the courses
			System.out.println("\n\nAdd Mary new Courses...");
			course1.addStudent(theMary);
			course2.addStudent(theMary);
			
			//save courses
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
