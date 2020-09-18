package com.example.demo.service;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.CourseEnquiry;


public interface CSalespipelineService {
	
	public List<CourseEnquiry> viewCourseSalesPipeline();
	

}
