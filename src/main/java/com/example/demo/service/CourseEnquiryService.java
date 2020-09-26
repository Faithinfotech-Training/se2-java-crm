package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.CourseEnquiry;

public interface CourseEnquiryService {

	
	// Create a course enquiry
	public void saveCourseEnquiry(CourseEnquiry courseEnquiry);
	
	// List all course enquiries
	public List<CourseEnquiry> findAllCourseEnquiry();
	
	// Find course enquiry by id
	public CourseEnquiry findCourseEnquiryById(Integer id);

	
	// Update course enquiry by id
	public String updateCourseEnquiry(CourseEnquiry courseEnquiry);
	
	// Delete course enquiry By id
	public CourseEnquiry deleteCourseEnquiry(Integer id);

	//get list of enquiries by status
	public List<CourseEnquiry> findAllCourseEnquiryByStatus(int enquiryStatus);
	
	
	
}
