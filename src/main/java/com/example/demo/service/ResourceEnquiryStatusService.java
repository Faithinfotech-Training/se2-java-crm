package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ResourceEnquiryStatus;

public interface ResourceEnquiryStatusService {
	
	// create enquiry status
		public void saveResourceEnquiryStatus(ResourceEnquiryStatus enquiryStatus);
		
		// findall enquiry status
		public List<ResourceEnquiryStatus> findAllResourceEnquiryStatus();
		
		// find enquiryStatus by Id
		public ResourceEnquiryStatus findResourceEnquiryStatusById(Integer id);
		
		// update enquiry status
		public boolean updateResourceEnquiryStatus(ResourceEnquiryStatus enquiryStatus);
		
		// delete enquiry status
		public ResourceEnquiryStatus deleteEnquiryStatus(Integer id);

}
