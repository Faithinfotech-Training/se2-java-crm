package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ResourceEnquiry;

public interface ResourceEnquiryService {

	
	public List<ResourceEnquiry> findAllResourceEnquiry();
	
	
	public ResourceEnquiry findByResourceEnquiryId(int theId);
	
	public void saveResourceEnquiry(ResourceEnquiry resourceEnquiry);
	
	public void updateResourceEnquiry(int resourceEnquiryId, ResourceEnquiry resourceEnquiry);
	
	public void deleteByResourceEnquiryId(int resourceEnquiryId);
	
	
}
