package com.filpatterson.jdbc.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.filpatterson.jdbc.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		//	start session
		session.beginTransaction();
		
		Student student = new Student("gaben", "richards", "richards-gabe-new@gmail.com");
		
		//	save new student into database
		session.save(student);
		session.getTransaction().commit();
		
		//	create another session for reading student
		session = factory.getCurrentSession();
		session.beginTransaction();
		
		//	get student from database
		Student anotherStudent = session.get(Student.class, student.getId());
		System.out.println(anotherStudent);
		
		//	finalize getting
		session.getTransaction().commit();
		
		//	each new transaction requires getting current session, otherwise error will be thrown
		session = factory.getCurrentSession();
		session.beginTransaction();
		
		//	get list of all students
		List<Student> students = session.createQuery("from Student").getResultList();
		System.out.println(students);
		
		//	perform getting all students
		session.getTransaction().commit();
		
		System.out.println("Done!");
	}

}
