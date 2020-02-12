package com.luv2code.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().
										configure().
										addAnnotatedClass(Student.class).
										buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{
			//open new session
			session =factory.getCurrentSession();
			session.beginTransaction();
			
			//query Students
			List<Student> students= session.createQuery("from Student s where s.firstName like 'firstName%'").getResultList();

			displayStudents(students);
			
			//commit the transaction
			session.getTransaction().commit();		
			
		}finally{
			factory.close();
		}		

	}

	private static void displayStudents(List<Student> students) {
		//display the students
		int i=0;
		for (Student student : students) {
			System.out.println(String.format("student[%d]: %s",++i,student));
		}
	}

}
