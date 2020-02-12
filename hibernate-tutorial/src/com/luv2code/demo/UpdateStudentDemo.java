package com.luv2code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().
										configure().
										addAnnotatedClass(Student.class).
										buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{
			
			session.beginTransaction();
			///find out the student
			Student readStudent = session.get(Student.class, 1);
			
			
			//print readStudent
			System.out.println("Read student: "+readStudent);
			
			readStudent.setFirstName("Scooby");
			
			//commit the transaction
			session.getTransaction().commit();
			
			
		}finally{
			factory.close();
		}		

	}

}
