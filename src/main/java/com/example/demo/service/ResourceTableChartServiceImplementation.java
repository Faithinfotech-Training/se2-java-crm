package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.CourseEnquiryDAO;
import com.example.demo.dao.CourseEnquiryDAOImpl;
import com.example.demo.dao.ResourceEnquiryDAO;
import com.example.demo.dao.ResourceEnquiryDAOImplementation;
import com.example.demo.entity.CourseEnquiry;
import com.example.demo.entity.ResourceEnquiry;

@Service
public class ResourceTableChartServiceImplementation implements ResourceTableChartService {

	private ResourceEnquiryDAO resourceEnquiryDAO;
	private ResourceEnquiryDAOImplementation resourceEnquiryDAOImplementation;
	
	@Autowired
	public ResourceTableChartServiceImplementation(@Qualifier("resourceEnquiryDAOImplementation") ResourceEnquiryDAO resourceEnquiryDAO) {
		
		this.resourceEnquiryDAO=resourceEnquiryDAO;
	}
	
	
	@Override
	@Transactional
	public List<ResourceEnquiry> viewResourceTable() {
		
		return resourceEnquiryDAO.viewResourceTable();
	}
	

}


	
	

	

