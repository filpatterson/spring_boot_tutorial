package com.filpatterson.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.filpatterson.jdbc.entity.Course;
import com.filpatterson.jdbc.entity.Instructor;
import com.filpatterson.jdbc.entity.InstructorDetail;
import com.filpatterson.jdbc.entity.Review;
import com.filpatterson.jdbc.entity.Student;

public class CreateCourseWithStudentsDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Student student1 = new Student("mary", "linton", "some_email@gmail.com");
			Student student2 = new Student("alan", "wake", "worst_game@gmail.com");
			Student student3 = new Student("jack", "daniels", "bad_stuff@gmail.com");
			Student student4 = new Student("general", "kenoby", "star_citizen@gmail.com");
			Student student5 = new Student("obi", "one", "reference_toSW@gmail.com");
			Student student6 = new Student("spidey", "man", "radioactive_bite@gmail.com");
			
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
			
			course1.addStudent(student1);
			course1.addStudent(student2);
			course3.addStudent(student3);
			course4.addStudent(student4);
			course4.addStudent(student5);
			course4.addStudent(student6);
			course6.addStudent(student1);
			
			session.save(course1);
			session.save(course2);
			session.save(course3);
			session.save(course4);
			session.save(course5);
			session.save(course6);
			
			session.save(student1);
			session.save(student2);
			session.save(student3);
			session.save(student4);
			session.save(student5);
			session.save(student6);
		
			session.getTransaction().commit();
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
