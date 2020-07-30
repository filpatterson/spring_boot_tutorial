package com.filpatterson.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.filpatterson.jdbc.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			int studentID = 1;
			session.beginTransaction();
			
			//	get reference to the student with id 1 and try updating its value
			Student student = session.get(Student.class, studentID);
			student.setFirstName("Dmitriy");
			
			session.getTransaction().commit();
			
			//	---------------------	another change operation	-----------------------------
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//	update all emails of all students
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
		
		
	}

}
