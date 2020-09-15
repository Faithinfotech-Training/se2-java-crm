package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Course;

public interface CourseDAO {
	
	public List<Course> findAllCourse();
	
	public Course findCourseById(int courseId);
	
	public void save(Course course);
	
	public void deleteCourseById(int courseId);

}
