package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Course;

public interface CourseDAO {
	//view all courses
	public List<Course> findAllCourse();
	//view courses by id
	public Course findCourseById(int courseId);
	// Create a course 
	public void save(Course course);
	//delete a course
	public void deleteCourseById(int courseId);

}
