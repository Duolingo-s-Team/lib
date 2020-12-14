package com.duolingo.client.rmi;

import java.util.ArrayList;

import com.duolingo.client.rmi.interfaces.ICom;

import implementations.CourseImpl;
import interfaces.ICourse;
import models.Course;

public class ComImpl implements ICom {
	
//	public ComImpl() {}
//
//	@Override
//	public ArrayList<Course> getData() {
//		ICourse courseManager = new CourseImpl();
//		ArrayList<Course> course = (ArrayList<Course>) courseManager.getAllCourses();
//		System.out.println("COURSES: ");
//		course.forEach(System.out::println);
//
//		return course;
//	}	
	
	@Override
	public ArrayList<String> getData() {
		ICourse courseManager = new CourseImpl();
		ArrayList<Course> course = (ArrayList<Course>) courseManager.getAllCourses();
				
		ArrayList<String> courseNames = new ArrayList<>();
		
		course.forEach((n) -> courseNames.add(n.toString()));
		
		System.out.println(courseNames);
				
		return courseNames;
	}
	
}
