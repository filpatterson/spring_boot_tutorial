package com.filpatterson.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.filpatterson.jdbc.entity.Instructor;
import com.filpatterson.jdbc.entity.InstructorDetail;

public class DestroyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			//	get instructor from db with index 1
			Instructor instructor = session.get(Instructor.class, 1);
			
			if(instructor != null) {
				System.out.println("deleting element...");
				session.delete(instructor);
				session.getTransaction().commit();
				System.out.println("Done!");
			} else
				System.out.println("there is an error: no such element in database");
		} finally {
			session.close();
			factory.close();
		}
	}

}
