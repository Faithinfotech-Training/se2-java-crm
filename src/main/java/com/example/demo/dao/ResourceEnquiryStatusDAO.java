package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.ResourceEnquiryStatus;

public interface ResourceEnquiryStatusDAO {


	// create enquiry status
	public void saveEnquiryStatus(ResourceEnquiryStatus resourceEnquiryStatus);
	
	// findall enquiry status
	public List<ResourceEnquiryStatus> findAllEnquiryStatus();
	
	// find enquiryStatus by Id
	public ResourceEnquiryStatus findEnquiryStatusById(Integer id);
	
	// update enquiry status
	public boolean updateEnquiryStatus(ResourceEnquiryStatus ResourceEnquiryStatus);
	
	// delete enquiry status
	public ResourceEnquiryStatus deleteEnquiryStatus(Integer id);
	
	
}
