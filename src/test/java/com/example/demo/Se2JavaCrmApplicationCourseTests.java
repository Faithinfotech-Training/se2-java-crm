package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.CourseDAO;
import com.example.demo.entity.Access;
import com.example.demo.entity.Course;
import com.example.demo.entity.Domain;
import com.example.demo.entity.Qualification;
import com.example.demo.entity.Status;
import com.example.demo.service.CourseService;



@RunWith(SpringRunner.class)
@SpringBootTest
class Se2JavaCrmApplicationCourseTests {

	@Autowired
	private CourseService courseService;
	@MockBean
	private CourseDAO coursesDAO;

	@Test
	public void injectedServicesAreNotNull() {
		assertThat(courseService).isNotNull();
	}
	
	//Check if saveCourse works
	@Test
	public void saveCourseTest() {
		
		Status status = new Status(1,"Active");
		Access access = new Access(1,"Private");
		Domain domain = new Domain("Java");
		Qualification qualification = new Qualification("BE","60");
		
		Course courses = new Course("Basic JAVA", "OOPS of Java", 499, 700, 25, "30", domain, access, status, qualification);
		when(coursesDAO.findAllCourse()).thenReturn(Stream.of(courses).collect(Collectors.toList()));
		
		assertEquals(1, courseService.findAllCourse().size());
	}

	//Check if findAllCourse works
	@Test
	public void findAllCourseTest() {
		
		Status status = new Status(1,"Active");
		Access access = new Access(1,"Private");
		Domain domain = new Domain("Java");
		Qualification qualification = new Qualification("BE","60");
		
		Course courses = new Course("Basic JAVA", "OOPS of Java", 499, 700, 25, "30", domain, access, status, qualification);
		when(coursesDAO.findAllCourse()).thenReturn(Stream.of(courses).collect(Collectors.toList()));
		
		assertEquals(1, courseService.findAllCourse().size());
		
		
	}
	
	
	//Check if findCourseById works
	@Test
	public void findAllCourseByIdTest() {
		
		Status status = new Status(1,"Active");
		Access access = new Access(1,"Private");
		Domain domain = new Domain("Java");
		Qualification qualification = new Qualification("BE","60");
		
		Course courses = new Course("Basic JAVA", "OOPS of Java", 499, 700, 25, "30", domain, access, status, qualification);
		when(coursesDAO.findCourseById(1)).thenReturn(courses);

		assertEquals(new Integer(20), courseService.findCourseById(1).getCourseName());
		
		
	}

}
