package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ResourceEnquiry;

public interface ManageResEnquiryUpdateService {

	/*
	 * Return resource enquiries in order of importance.
	 * The oldest resource enquiries come first.
	 */	
	public List<ResourceEnquiry> findAllSortedResourceEnquiry();
	
	/*
	 * Return all the Resource Enquiries of the given type.
	 */
	public List<ResourceEnquiry> findAllResourceEnquiry(String resourceEnquiryStatus);
	
}
