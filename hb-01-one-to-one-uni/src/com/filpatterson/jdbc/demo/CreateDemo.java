package com.filpatterson.jdbc.demo;

import java.text.ParseException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.filpatterson.jdbc.entity.Instructor;
import com.filpatterson.jdbc.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) throws ParseException {
		
		//		initialize factory, set configuration file (this is default value, not necessary to write it),
		//	add class for connection with table
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		//	create session
		Session session = factory.getCurrentSession();
		
		try {
			Instructor instructor = new Instructor("paul", "woker", "paul-woker-worker@gmail.com");
			InstructorDetail instructorDetail = new InstructorDetail("paul-worker-official", "love working");
			instructor.setInstructorDetail(instructorDetail);
			
			Instructor instructor2 = new Instructor("beatrice", "suspect", "beatrice-high-suspect@gmail.com");
			InstructorDetail instructorDetail2 = new InstructorDetail("betriceX-official", "love coding");
			instructor2.setInstructorDetail(instructorDetail2);
			
			//	start database operations
			session.beginTransaction();
			System.out.println("Saving the instructor..");
			
			//	make database operation
			session.save(instructor);
			session.save(instructor2);
			
			//	finalize operations
			session.getTransaction().commit();
			System.out.println("done");
		} finally {
			//	close factory for correct work
			factory.close();
		}
	}

}
