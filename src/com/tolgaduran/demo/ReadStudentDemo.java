package com.tolgaduran.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session=factory.getCurrentSession();

		try {
			session.beginTransaction();

			// query students
			List<Student> theStudent=session.createQuery("from Student").list();

			// display students
			displayStudents(theStudent);

			// query students: lastname='Doe'
			theStudent=session.createQuery("from Student s where s.lastName='Doe'").getResultList();

			System.out.println("\n");
			displayStudents(theStudent);
			
			// query students: lastname='Doe' or firtsname ='Tolga'
			theStudent=session.createQuery("from Student s where s.lastName='Doe' or firstName='Tolga'").getResultList();
			
			System.out.println("\n");
			displayStudents(theStudent);
			
			//query students: email like '%luv2code.com'
			theStudent=session.createQuery("from Student s where s.email like '%luv2code.com'").getResultList();
			
			System.out.println("\n");
			displayStudents(theStudent);

			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudent) {
		for(Student temp:theStudent) {
			System.out.println(temp);
		}
	}
}
