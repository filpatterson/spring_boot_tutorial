package com.filpatterson.jdbc.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.filpatterson.jdbc.entity.Course;
import com.filpatterson.jdbc.entity.Instructor;
import com.filpatterson.jdbc.entity.InstructorDetail;
import com.filpatterson.jdbc.entity.Review;

public class DeleteCourseWithReviewsDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			int deleteCourseId = 12;
			Course course = session.get(Course.class, deleteCourseId);
			session.delete(course);
			
			session.getTransaction().commit();
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
