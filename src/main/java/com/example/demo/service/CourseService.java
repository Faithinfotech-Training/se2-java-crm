package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Course;

public interface CourseService {
	//get all courses
	public List<Course> findAllCourse();
	//get courses by id
	public Course findCourseById(int courseId);
	//insert courses
	public void save(Course course);
	//delete course by id
	public void deleteCourseById(int courseId);
	
}
