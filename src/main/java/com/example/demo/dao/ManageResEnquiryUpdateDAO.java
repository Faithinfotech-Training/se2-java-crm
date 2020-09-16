package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.ResourceEnquiry;

public interface ManageResEnquiryUpdateDAO {
	
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
