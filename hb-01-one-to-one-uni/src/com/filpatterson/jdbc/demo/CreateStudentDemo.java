package com.filpatterson.jdbc.demo;

import java.text.ParseException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.filpatterson.jdbc.entity.DateUtils;
import com.filpatterson.jdbc.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) throws ParseException {
		
		//		initialize factory, set configuration file (this is default value, not necessary to write it),
		//	add class for connection with table
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		//	create session
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating new student object");
			Student student = new Student("Paul", "Wall", "somecode@gmail.com", DateUtils.parseDate("12/12/1212"));
			
			//	start database operations
			session.beginTransaction();
			System.out.println("Saving the student..");
			
			//	make database operation
			session.save(student);
			
			//	finalize operations
			session.getTransaction().commit();
			System.out.println("done");
		} finally {
			//	close factory for correct work
			factory.close();
		}
	}

}
