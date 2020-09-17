package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CourseEnquiry;

@Repository
public class ManageCorEnquiryUpdateDAOImp implements ManageCorEnquiryUpdateDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	public ManageCorEnquiryUpdateDAOImp(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public List<CourseEnquiry> findAllSortedCourseEnquiry() {
		Query query = entityManager.createQuery("from CourseEnquiry order by enquiry_date");
		List<CourseEnquiry> courseEnquiries = query.getResultList();
		return courseEnquiries;

	}

	@Override
	public List<CourseEnquiry> findAllCourseEnquiry(Integer EnquiryStatus) {
		System.out.println(EnquiryStatus.toString());
		Query query = entityManager.createQuery("from CourseEnquiry where status_id = " + EnquiryStatus.toString());
		List<CourseEnquiry> courseEnquiries = query.getResultList();
		return courseEnquiries;
	}

}
