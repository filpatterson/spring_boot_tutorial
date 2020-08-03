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

public class GetReviewsDemo {

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
			
			List<Course> courses = new ArrayList<>();
			List<Integer> coursesIDs = new ArrayList<>();
			coursesIDs.add(10);
			coursesIDs.add(12);
			coursesIDs.add(13);
			
			for(int i = 0; i < coursesIDs.size(); i++)
				courses.add(session.get(Course.class, coursesIDs.get(i)));
			
			//	remember that review will be loaded only on demand
			for(int i = 0; i < courses.size(); i++) {
				System.out.println(courses.get(i));
				System.out.println(courses.get(i).getReviews());
			}
		
			session.getTransaction().commit();
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
