package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.CourseDAO;
import com.example.demo.entity.Course;

@Service
public class CourseServiceImp implements CourseService {

	CourseDAO courseDAO;
	
	@Autowired
	public CourseServiceImp(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	@Override
	@Transactional
	public List<Course> findAllCourse() {
		return courseDAO.findAllCourse();
	}

	@Override
	@Transactional
	public Course findCourseById(int courseId) {
		return courseDAO.findCourseById(courseId);
	}

	@Override
	@Transactional
	public void save(Course course) {
		courseDAO.save(course);
	}

	@Override
	@Transactional
	public void deleteCourseById(int courseId) {
		courseDAO.deleteCourseById(courseId);
	}

}
