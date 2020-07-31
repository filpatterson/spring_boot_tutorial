package com.filpatterson.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.filpatterson.jdbc.entity.Course;
import com.filpatterson.jdbc.entity.Instructor;
import com.filpatterson.jdbc.entity.InstructorDetail;

public class CreateAndGetOneToManyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
//			session.beginTransaction();
//			
//			Instructor instructor = new Instructor("beatrice", "XXX", "filpatterson10@gmail.com");
//			InstructorDetail instructorDetail = new InstructorDetail("filpatterson-official", "love bad coding");
//			instructor.setInstructorDetail(instructorDetail);
//			
//			Course course1 = new Course("asus learning");
//			Course course2 = new Course("laptop processing");
//			instructor.add(course1);
//			instructor.add(course2);
//			
//			session.save(instructor);
//			session.save(course1);
//			session.save(course2);
//			
//			session.getTransaction().commit();
//			
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			
//			Instructor readInstructor = session.get(Instructor.class, 8);
//			System.out.println(readInstructor);
//			
//			session.getTransaction().commit();
//			
//			session = factory.getCurrentSession();
			session.beginTransaction();
			
//			Course courseToDelete = session.get(Course.class, 15);
//			session.delete(courseToDelete);
			Instructor instructorToGet = session.get(Instructor.class, 5);
			System.out.println(instructorToGet);
			
			session.getTransaction().commit();
		} finally {
			session.close();
			factory.close();
		}
	}

}
