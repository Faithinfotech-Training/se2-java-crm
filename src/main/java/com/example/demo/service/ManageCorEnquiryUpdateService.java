package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.CourseEnquiry;

public interface ManageCorEnquiryUpdateService {

	public List<CourseEnquiry> findAllSortedCourseEnquiry();

	public List<CourseEnquiry> findAllCourseEnquiry(Integer EnquiryStatus);
}
