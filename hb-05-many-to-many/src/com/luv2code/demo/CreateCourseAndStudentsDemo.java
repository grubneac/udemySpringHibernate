package com.luv2code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

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
			
			//create  a course
			Course course = new Course("Pacman - How To Scope One Million Points");
			
			//save the course and cascade revies
			session.save(course);
			
			//add students
			Student student1 = new Student("John", "Doe", "john@mail.ru");
			Student student2 = new Student("Mary", "Public", "jmary@mail.ru");
			
			//add students to the course
			course.addStudent(student1);
			course.addStudent(student2);
			
			//save students
			System.out.println("\nSaving students....");
			session.save(student1);
			session.save(student2);
			System.out.println("\nSaved students "+course.getStudents());
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}finally{
			session.close();
			factory.close();
		}		

	}

}
