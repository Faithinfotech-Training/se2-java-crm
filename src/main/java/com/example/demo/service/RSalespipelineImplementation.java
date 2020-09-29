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
import com.example.demo.entity.CourseLeadResponseDTO;
import com.example.demo.entity.ResourceEnquiry;

@Service
public class RSalespipelineImplementation implements RSalespipeline
{

	private ResourceEnquiryDAO resourceEnquiryDAO;
	private ResourceEnquiryDAOImplementation resourceEnquiryDAOImp;
	

	
	@Autowired
	public RSalespipelineImplementation(@Qualifier("resourceEnquiryDAOImplementation") ResourceEnquiryDAO resourceEnquiryDAO) {
		super();
		this.resourceEnquiryDAO=resourceEnquiryDAO;
	}
	
	@Override
	@Transactional
	public List<ResourceEnquiry> viewResourcesSalesPipeline() {
	
		return resourceEnquiryDAO.viewResourceSalesPipeline();
	}

	@Override
	public List<CourseLeadResponseDTO> viewResourceLeadsSalesPipeline() {
		
		return resourceEnquiryDAO.viewLeadSalesPipeline();
	}

}
