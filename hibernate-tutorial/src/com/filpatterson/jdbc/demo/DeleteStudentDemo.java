package com.filpatterson.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.filpatterson.jdbc.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			int studentToDeleteID = 1;
			session.beginTransaction();
			
			Student studentToDelete = session.get(Student.class, studentToDeleteID);
			session.delete(studentToDelete);
			
			session.getTransaction().commit();
			
			//	---------------------------	another delete method	-----------------------------
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			session.getTransaction().commit();
		} finally {	
			factory.close();
		}
	}
}
