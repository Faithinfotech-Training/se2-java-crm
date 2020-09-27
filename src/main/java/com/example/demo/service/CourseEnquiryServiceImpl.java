package com.example.demo.service;

import java.sql.Date;
import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CourseEnquiryDAO;

import com.example.demo.entity.CourseEnquiry;


@Service
public class CourseEnquiryServiceImpl implements CourseEnquiryService {

	// Course Enquiry DAO Instance
	private CourseEnquiryDAO courseEnquiryDAO;
	
	
	@Autowired
	public CourseEnquiryServiceImpl(CourseEnquiryDAO courseEnquiryDAO) {
		super();
		this.courseEnquiryDAO = courseEnquiryDAO;
	}

	@Override
	@Transactional
	public void saveCourseEnquiry(CourseEnquiry courseEnquiry) {
		// Save a course enquiry
		courseEnquiryDAO.saveCourseEnquiry(courseEnquiry);
	}

	@Override
	@Transactional
	public List<CourseEnquiry> findAllCourseEnquiry() {
		// Find All course enquiry
		return courseEnquiryDAO.findAllCourseEnquiry();
	}

	@Override
	@Transactional
	public CourseEnquiry findCourseEnquiryById(Integer id) {
		// Find course enquiry by id
		return courseEnquiryDAO.findCourseEnquiryById(id);
	}

	@Override
	@Transactional
	public boolean updateCourseEnquiry(CourseEnquiry courseEnquiry) {
		// Update course enquiry
		return courseEnquiryDAO.updateCourseEnquiry(courseEnquiry);
	}

	@Override
	@Transactional
	public CourseEnquiry deleteCourseEnquiry(Integer id) {
		// Delete course enquiry by Id
		return courseEnquiryDAO.deleteCourseEnquiry(id);
	}

	@Override
	@Transactional
	public List<CourseEnquiry> findAllCourseEnquiryByStatus(int enquiryStatus) {
		//find enquiry by status
		return courseEnquiryDAO.findAllCourseEnquiryByStatus(enquiryStatus);
	}
	
	@Override
	@Transactional
	public List<CourseEnquiry> findAllCourseEnquiryByDate(String startDate,String endDate) {
		//find enquiry by dATE
		return courseEnquiryDAO.findAllCourseEnquiryByDate(startDate, endDate);
	}

	@Override
	@Transactional
	public int findAllCourseEnquiryCount() {
		// TODO Auto-generated method stub
		return courseEnquiryDAO.findAllCourseEnquiryCount();
	}

	@Override
	@Transactional
	public List<CourseEnquiry> findAllCourseEnquiryByDateAndStatus(String startDate, String endDate, int status) {
		// TODO Auto-generated method stub
		return courseEnquiryDAO.findAllCourseEnquiryByDateAndStatus(startDate, endDate, status);
	}
	
}
