package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Course;

public interface CourseService {

	public List<Course> findAllCourse();
	
	public Course findCourseById(int courseId);
	
	public void save(Course course);
	
	public void deleteCourseById(int courseId);
	
}
