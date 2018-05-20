package com.tolgaduran.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			Student theStudent2=new Student("John", "Doe", "john@luv2code.com");
			
			session.beginTransaction();
			
			session.save(theStudent2);
			
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}
}
