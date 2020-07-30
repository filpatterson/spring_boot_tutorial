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
		
//		Student student = new Student("gaben", "richards", "richards-gabe-new@gmail.com");
//		
//		//	save new student into database
//		session.save(student);
//		session.getTransaction().commit();
//		
//		//	create another session for reading student
//		session = factory.getCurrentSession();
//		session.beginTransaction();
		
//		//	get student from database
//		Student anotherStudent = session.get(Student.class, student.getId());
//		System.out.println(anotherStudent);
//		
//		//	finalize getting
//		session.getTransaction().commit();
//		
//		//	each new transaction requires getting current session, otherwise error will be thrown
//		session = factory.getCurrentSession();
//		session.beginTransaction();
		
		//	get list of all students
		List<Student> students = session.createQuery("from Student").getResultList();
		showStudents(students);
		
		//	perform getting all students
		session.getTransaction().commit();
		
		//	-----------------------	another operation	---------------------------------------------------
		
		//	start new session
		session = factory.getCurrentSession();
		session.beginTransaction();
		
		//	get students with lastname Cretu or name Beatrice
		students = session.createQuery("from Student student where student.lastName='Cretu' or student.firstName='Beatrice'").getResultList();
		showStudents(students);
		
		//	perform getting all students
		session.getTransaction().commit();
		
		//	--------------------------	another operation	----------------------------------------------
		
		//	start new session
		session = factory.getCurrentSession();
		session.beginTransaction();
		
		//	get students with lastname Cretu or name Beatrice
		students = session.createQuery("from Student student where student.email like '%@gmail.com'").getResultList();
		showStudents(students);
		
		//	perform getting all students
		session.getTransaction().commit();
		
		System.out.println("Done!");
		
		factory.close();
	}

	private static void showStudents(List<Student> students) {
		for(int i = 0; i < students.size(); i++)
			System.out.println(students.get(i));
	}

}
