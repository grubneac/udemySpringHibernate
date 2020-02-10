package com.luv2code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().
										configure().
										addAnnotatedClass(Student.class).
										buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{
			//create a student object
			Student st = new Student("Daffy", "Duck", "daffy@mail.ru");
			
			//start transaction
			session.beginTransaction();
			
			//save the student
			session.save(st);
			
			//commit the transaction
			session.getTransaction().commit();
			
			//open new session
			session =factory.getCurrentSession();
			session.beginTransaction();
			///find out the student
			Student readStudent = session.get(Student.class, st.getId());
			
			
			//print readStudent
			System.out.println("Read student: "+readStudent);
			
			//commit the transaction
			session.getTransaction().commit();
			
			
		}finally{
			factory.close();
		}		

	}

}
