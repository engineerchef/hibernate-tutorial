package com.tolgaduran.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			int studentId=2;
			
			session.beginTransaction();
			
			Student theStudent=session.get(Student.class, studentId);
						
			// updating student
			theStudent.setFirstName("Scooby");
			System.out.println(theStudent);
			
			session.getTransaction().commit();
			
			// NEW CODE
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			// update email for all students
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			
			
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}
}
