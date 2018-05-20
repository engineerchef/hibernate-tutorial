package com.tolgaduran.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			int studentId=2;
			
			session.beginTransaction();
			
			// Student theStudent=session.get(Student.class, studentId);
			// session.delete(theStudent);
			
			// NEW CODE
			// delete studentID=3
			session.createQuery("delete from Student where id=3").executeUpdate();
			
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}
}
