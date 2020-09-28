package com.example.demo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.CourseEnquiryDAO;
import com.example.demo.dao.CourseEnquiryDAOImpl;
import com.example.demo.entity.CourseEnquiry;
import com.example.demo.entity.CourseEnquiryStatusDTO;

@Service
public class CourseTableChartServiceImplementation implements CourseTableChartService {

	private CourseEnquiryDAO courseEnquiryDAO;
	private CourseEnquiryDAOImpl courseEnquiryDAOImp;
	

	
	@Autowired
	public CourseTableChartServiceImplementation(@Qualifier("courseEnquiryDAOImpl") CourseEnquiryDAO courseEnquiryDAO) {
		super();
		this.courseEnquiryDAO=courseEnquiryDAO;
	}
	
	

	@Override
	@Transactional
	public List<CourseEnquiryStatusDTO> viewCourseTable() {
	
		return courseEnquiryDAO.viewCourseTable();
	}
}