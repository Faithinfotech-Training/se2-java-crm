<<<<<<< HEAD
package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Course;

@Repository
public class CourseDAOImp implements CourseDAO {

	EntityManager entityManager;

	@Autowired
	public CourseDAOImp(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Course> findAllCourse() {
		// create query for find all course
		Query query = entityManager.createQuery("from Course");
		// save result to list of course
		List<Course> course = query.getResultList();
		// return course
		return course;
	}

	@Override
	public Course findCourseById(int courseId) {
		// find course by id
		Course course = entityManager.find(Course.class, courseId);
		// return the result
		return course;
	}

	@Override
	public void save(Course course) {
		// insert new course
		Course tempCourse = entityManager.merge(course);
		course.setCourseId(tempCourse.getCourseId());

	}

	@Override
	public void deleteCourseById(int courseId) {
		// delete query for course table
		Query query = entityManager.createNativeQuery("DELETE FROM COURSE WHERE COURSE_ID = " + courseId);
		// execute delete query
		query.executeUpdate();
	}

}
=======
package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Course;

@Repository
public class CourseDAOImp implements CourseDAO {

	EntityManager entityManager;

	@Autowired
	public CourseDAOImp(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Course> findAllCourse() {
		// create query for find all course
		Query query = entityManager.createQuery("from Course");
		// save result to list of course
		List<Course> course = query.getResultList();
		// return course
		return course;
	}

	@Override
	public Course findCourseById(int courseId) {
		// find course by id
		Course course = entityManager.find(Course.class, courseId);
		// return the result
		return course;
	}

	@Override
	public void save(Course course) {
		// insert new course
		Course tempCourse = entityManager.merge(course);
		course.setCourseId(tempCourse.getCourseId());

	}

	@Override
	public void deleteCourseById(int courseId) {
		// delete query for course table
		Query query1 = entityManager.createNativeQuery("DELETE FROM COURSE WHERE COURSE_ID = " + courseId);
		Query query2 = entityManager.createNativeQuery("DELETE FROM QUALIFICATION_COURSE WHERE COURSE_ID = " + courseId);
		// execute delete query
		query2.executeUpdate();
		query1.executeUpdate();
	}

}
>>>>>>> 5f19ed8f8d38ffa3256101883bb0c8f6c5603409
