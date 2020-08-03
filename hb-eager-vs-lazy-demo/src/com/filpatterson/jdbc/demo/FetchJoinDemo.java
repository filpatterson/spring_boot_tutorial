package com.filpatterson.jdbc.demo;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.filpatterson.jdbc.entity.Course;
import com.filpatterson.jdbc.entity.Instructor;
import com.filpatterson.jdbc.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			int theID = 5;
			
			//	create query with parameter and execute it after all preparations
			Query<Instructor> query = session.createQuery("select i from Instructor i "
														+ "JOIN FETCH i.courses "
														+ "where i.id=:theInstructorID", 
														Instructor.class);
			
			query.setParameter("theInstructorID", theID);
			Instructor instructor = query.getSingleResult();
			
			System.out.println(instructor);
			System.out.println(instructor.getCourses());
			
			/*
			 * 	If there is error of fault proxy or fault entity using lazy initialization
			 * then it's problem of closing connection before getting access to the lazy data.
			 * It can be solved via several options:
			 * 		1. make getter of lazy data before closing session (can be accessed after closing connection);
			 * 		2. make hql request (shown above)
			 */
			
			
			/*
			 * Another problem is setting call for courses later in applications. For this, make:
			 * 	session = factory.getCurrentSession();
			 * 	session.beginTransaction();
			 * 
			 * 	Query<Course> query = session.createQuery("select c from Course c "
			 * 										+ "where c.instructor.id=:theInstructorID",
			 * 										Course.class);
			 * 	query.setParameter("theInstructorID, theID);
			 * 	List<Course> courses = query.getResultList();
			 */
			
			session.getTransaction().commit();
		} finally {
			session.close();
			factory.close();
		}
	}

}
