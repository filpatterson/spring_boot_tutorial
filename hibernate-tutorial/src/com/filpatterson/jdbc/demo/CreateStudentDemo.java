package com.filpatterson.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.filpatterson.jdbc.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		//	create session
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating new student object");
			Student student = new Student("Paul", "Wall", "somecode@gmail.com");
			
			session.beginTransaction();
			System.out.println("Saving the student..");
			session.save(student);
			
			session.getTransaction().commit();
			System.out.println("done");
		} finally {
			factory.close();
		}
	}

}
