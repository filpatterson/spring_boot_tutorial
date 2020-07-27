package com.filpatterson.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbcURL = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String password = "hbstudent";
		
		try {
			System.out.println("Connecting to the database: " + jdbcURL);
			
			Connection connection = DriverManager.getConnection(jdbcURL, user, password);
			System.out.println("Connection successful!");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
