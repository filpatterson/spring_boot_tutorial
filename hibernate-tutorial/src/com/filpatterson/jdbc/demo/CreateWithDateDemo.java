package com.filpatterson.jdbc.demo;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.filpatterson.jdbc.DateUtils;
import com.filpatterson.jdbc.Student;

public class CreateWithDateDemo {

	public static void main(String[] args) throws ParseException {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			//	create new element with datetime object inside
			Student student = new Student("anatol", "bivol", "bivol__anatol__@gmail.com", DateUtils.parseDate("12/12/1997"));
			
			//	create new transaction and save new element
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}

}
