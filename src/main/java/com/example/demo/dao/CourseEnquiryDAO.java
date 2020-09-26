package com.example.demo.dao;

import java.sql.Date;
import java.util.List;

import com.example.demo.entity.CourseEnquiry;

public interface CourseEnquiryDAO {
	
	// Create a course enquiry
	public void saveCourseEnquiry(CourseEnquiry courseEnquiry);
	
	// List all course enquiries
	public List<CourseEnquiry> findAllCourseEnquiry();
	
	// Find course enquiry by id
	public CourseEnquiry findCourseEnquiryById(Integer id);
	
	// Update course enquiry by id
	public boolean updateCourseEnquiry(CourseEnquiry courseEnquiry);
	
	// Delete course enquiry By id
	public CourseEnquiry deleteCourseEnquiry(Integer id);
	
	//list all course enquiry by Status
	public List<CourseEnquiry> findAllCourseEnquiryByStatus(int enquiryStatus);

	public List<CourseEnquiry> viewCourseSalesPipeline();

	public List<CourseEnquiry> viewCourseTable();

	//list all course enquiry by dates
	List<CourseEnquiry> findAllCourseEnquiryByDate(Date startDate, Date endDate);


	


	

}
