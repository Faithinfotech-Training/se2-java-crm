package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.dao.CourseEnquiryDAO;
import com.example.demo.entity.CourseEnquiry;

@Service
public class CourseEnquiryServiceImpl implements CourseEnquiryService {

	
	private CourseEnquiryDAO courseEnquiryDAO;
	
	@Override
	@Transactional
	public void saveCourseEnquiry(CourseEnquiry courseEnquiry) {
		courseEnquiryDAO.saveCourseEnquiry(courseEnquiry);
	}

	@Override
	@Transactional
	public List<CourseEnquiry> findAllCourseEnquiry() {
		// TODO Auto-generated method stub
		return courseEnquiryDAO.findAllCourseEnquiry();
	}

	@Override
	@Transactional
	public CourseEnquiry findCourseEnquiryById(Integer id) {
		// TODO Auto-generated method stub
		return courseEnquiryDAO.findCourseEnquiryById(id);
	}

	@Override
	@Transactional
	public boolean updateCourseEnquiry(CourseEnquiry courseEnquiry) {
		// TODO Auto-generated method stub
		return courseEnquiryDAO.updateCourseEnquiry(courseEnquiry);
	}

	@Override
	@Transactional
	public CourseEnquiry deleteCourseEnquiry(Integer id) {
		// TODO Auto-generated method stub
		return courseEnquiryDAO.deleteCourseEnquiry(id);
	}

}
