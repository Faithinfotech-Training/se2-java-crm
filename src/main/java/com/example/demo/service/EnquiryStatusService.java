package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.EnquiryStatus;

public interface EnquiryStatusService {
	// create enquiry status
	public void saveEnquiryStatus(EnquiryStatus enquiryStatus);
	
	// findall enquiry status
	public List<EnquiryStatus> findAllEnquiryStatus();
	
	// find enquiryStatus by Id
	public EnquiryStatus findEnquiryStatusById(Integer id);
	
	// update enquiry status
	public boolean updateEnquiryStatus(EnquiryStatus enquiryStatus);
	
	// delete enquiry status
	public EnquiryStatus deleteEnquiryStatus(Integer id);
}
