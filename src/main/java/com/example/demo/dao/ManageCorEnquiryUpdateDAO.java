package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.CourseEnquiry;
import com.example.demo.entity.ResourceEnquiry;

public interface ManageCorEnquiryUpdateDAO {

	public List<CourseEnquiry> findAllSortedCourseEnquiry();

	public List<CourseEnquiry> findAllCourseEnquiry(Integer EnquiryStatus);

}
