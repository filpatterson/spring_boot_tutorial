package com.filpatterson.init;

import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

public class MyApp {

	public static void main (String[] args) {
		//	create the object
		Coach theCoach = new TrackCoach();
		
		//	use of the object
		System.out.println(theCoach.getDailyWorkout());
	}
}
