package com.filpatterson.jdbc.demo;



import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.filpatterson.jdbc.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			//	initialize array of new students to add into database
			ArrayList<Student> students = new ArrayList<>();
			students.add(new Student("Dima", "Cretu", "filpatterson10@gmail.com"));
			students.add(new Student("Paul", "Colt", "paul_colt_01@gmail.com"));
			students.add(new Student("Beatrice", "Kolm", "beatrice_kolm01@gmail.com"));
		
			session.beginTransaction();
			
			//	pass through all students individually and perform their save in database
			for(int i = 0; i < students.size(); i++)
				session.save(students.get(i));
			
			//	perform saving elements
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}

}
