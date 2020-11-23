package interfaces;

import java.util.List;

import models.Course;

public interface ICourse {

	public List<Course> getAllCourses();
	
	public Course getCourseById(long course_id);
	
	public boolean deleteCourse(Course course);
	
	public Course insertCourse(Course course);
	
	public Course updateCourse(Course course);
}
