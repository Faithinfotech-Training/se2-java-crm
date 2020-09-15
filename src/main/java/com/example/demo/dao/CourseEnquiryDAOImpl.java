package com.example.demo.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CourseEnquiry;

@Repository
public class CourseEnquiryDAOImpl implements CourseEnquiryDAO {

	private EntityManager entityManager;
	
	@Autowired
	public CourseEnquiryDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	
	@Override
	public void saveCourseEnquiry(CourseEnquiry courseEnquiry) {
		// TODO Auto-generated method stub
		entityManager.merge(courseEnquiry);
	}

	@Override
	public List<CourseEnquiry> findAllCourseEnquiry() {
		
		// Create a query
		Query myQuery = entityManager.createQuery("from CourseEnquiry");
		
		//extract the results
		List<CourseEnquiry> courseEnquiries = myQuery.getResultList();
		
		//return the course enquiries list
		return courseEnquiries;
	}

	@Override
	public CourseEnquiry findCourseEnquiryById(Integer id) {
		// find the courseEnquiry by Id
		CourseEnquiry courseEnquiry = entityManager.find(CourseEnquiry.class, id);
		return courseEnquiry;
	}

	@Override
	public boolean updateCourseEnquiry(CourseEnquiry courseEnquiry) {
		// TODO Auto-generated method stub
		entityManager.merge(courseEnquiry);
		return false;
	}

	@Override
	public CourseEnquiry deleteCourseEnquiry(Integer id) {
		//Find CourseEnquiry
		CourseEnquiry courseEnquiry = (CourseEnquiry) entityManager.find(CourseEnquiry.class, id);
		// If CourseEnquiry is present remove else return null
		if (entityManager.contains(courseEnquiry)) {
			entityManager.remove(courseEnquiry);
		} else {
			return null;
		}
		return courseEnquiry;
	}
}
