package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.CourseDAO;
import com.example.demo.entity.Course;

@Service
public class CourseServiceImp implements CourseService {
	// Course DAO Instance
	CourseDAO courseDAO;
	
	@Autowired
	public CourseServiceImp(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	@Override
	@Transactional
	public List<Course> findAllCourse() {
		//get all courses
		return courseDAO.findAllCourse();
	}

	@Override
	@Transactional
	public Course findCourseById(int courseId) {
		//get courses by id
		return courseDAO.findCourseById(courseId);
	}

	@Override
	@Transactional
	public void save(Course course) {
		//save a course
		courseDAO.save(course);
	}

	@Override
	@Transactional
	public void deleteCourseById(int courseId) {
		//delete course by id
		courseDAO.deleteCourseById(courseId);
	}

}
