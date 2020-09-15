package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Course;
import com.example.demo.service.CourseService;

@RestController
@RequestMapping("/api")
public class CourseController {
	
	private CourseService courseService;
	
	@Autowired
	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}


	@GetMapping("/course")
	public List<Course> findAllCourses() {
		return courseService.findAllCourse();
	}

	
	@GetMapping("/course/{courseId}")
	public Course getCourse(@PathVariable int courseId) {
		Course Course = courseService.findCourseById(courseId);
		if (Course == null) {
			throw new RuntimeException("Course id not found - " + courseId);
		}
		return Course;
	}

	@PostMapping("/course")
	public Course addCourse(@RequestBody Course Course) {
		Course.setCourseId(0);
		courseService.save(Course);
		return Course;
	}

	@DeleteMapping("/course/{courseId}")
	public String deleteCourseById(@PathVariable int courseId) {
		Course Course = courseService.findCourseById(courseId);
		if (Course == null) {
			throw new RuntimeException("Course id not found - " + courseId);
		}
		courseService.deleteCourseById(courseId);
		return "Deleted Course id - " + courseId;
	}
}