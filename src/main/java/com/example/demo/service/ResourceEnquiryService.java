package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ResourceEnquiry;

public interface ResourceEnquiryService {

	
	public List<ResourceEnquiry> findAllResourceEnquiry();
	
	
	public ResourceEnquiry findByResourceEnquiryId(int theId);
	
	public void saveResourceEnquiry(ResourceEnquiry resourceEnquiry);
	
	public String updateResourceEnquiry(ResourceEnquiry resourceEnquiry);
	
	public void deleteByResourceEnquiryId(int resourceEnquiryId);
	
	public List<ResourceEnquiry> findAllResourceEnquiryByStatus(int status);
	
	public List<ResourceEnquiry> findAllResourceEnquiryByResourceType(int resourceType);


	List<ResourceEnquiry> findAllResourceEnquiryByDateAndStatus(String startDate, String endDate, int status);


	int findAllResourceEnquiryCount();


	List<ResourceEnquiry> findAllResourceEnquiryByDate(String startDate, String endDate);
	
	
}
