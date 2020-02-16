package md.grubneac.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import md.grubneac.entities.Employee;

public class App {
	
	public static void main(String[] aggs) {
		SessionFactory sessionFactory = new Configuration()
											.configure()
											.addAnnotatedClass(Employee.class)
											.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			Employee employee = new Employee("Vasea4","Pecus4","Big Company4");
			session.beginTransaction();
			
			session.save(employee);

//			session.getTransaction().commit();
//			
//			session = sessionFactory.getCurrentSession();
//			session.beginTransaction();
			Employee readEmployee= session.get(Employee.class, 2);
			System.out.println("readEmployee="+readEmployee);
			
			List<Employee> employees = session.createQuery("from Employee e where e.company like '%Com%'").getResultList();
			
			Employee lastEmpl= new Employee();
			for (Employee employee2 : employees) {
				System.out.println("LISTS ="+employee2);
				lastEmpl= employee2;
			}
			
			session.delete(lastEmpl);
			
			session.getTransaction().commit();
			
		}finally{
			sessionFactory.close();
		}
	}
	
}
