package com.filpatterson.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.filpatterson.jdbc.entity.Course;
import com.filpatterson.jdbc.entity.Instructor;
import com.filpatterson.jdbc.entity.InstructorDetail;
import com.filpatterson.jdbc.entity.Review;

public class CreateCourseWithReviews {

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
			
			Course course1 = new Course("udemy lessons");
			Course course2 = new Course("laptop analysis");
			Course course3 = new Course("degradation tests");
			Course course4 = new Course("how to become loser");
			Course course5 = new Course("how to live like a loser");
			Course course6 = new Course("how to lie that you're not a loser");
			
			course1.addReview(new Review("they're good, but require a lot of time"));
			course1.addReview(new Review("i don't like method of getting new info, but it's acceptable"));
			course3.addReview(new Review("testing stupidity can be funny"));
			course4.addReview(new Review("well, i felt myself like getting back to the college"));
			course4.addReview(new Review("i lost my girl 'cause of this course, but found another one"));
			course4.addReview(new Review("now i feel myself as albert einstein if he was retarted, good course"));
			course6.addReview(new Review("i'm not a loser, but course was interesting")	);
			
			session.save(course1);
			session.save(course2);
			session.save(course3);
			session.save(course4);
			session.save(course5);
			session.save(course6);
		
			session.getTransaction().commit();
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
