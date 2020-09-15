package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.CourseEnquiry;

public interface CourseEnquiryService {

	
	// create a course enquiry
	public void saveCourseEnquiry(CourseEnquiry courseEnquiry);
	
	// list all course enquiries
	public List<CourseEnquiry> findAllCourseEnquiry();
	
	// find course enquiry by id
	public CourseEnquiry findCourseEnquiryById(Integer id);

	
	// update course enquiry by id
	public boolean updateCourseEnquiry(CourseEnquiry courseEnquiry);
	
	// delete course enquiry By id
	public CourseEnquiry deleteCourseEnquiry(Integer id);



	
}
