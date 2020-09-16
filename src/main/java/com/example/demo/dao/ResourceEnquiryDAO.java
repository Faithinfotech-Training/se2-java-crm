//Interface of the DAO Layer of Resource Enquiry
package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.ResourceEnquiry;

@Repository
public interface ResourceEnquiryDAO  {
    //method to get all resource enquiries
	List<ResourceEnquiry> findAll();
	
	//method to get a specific enquiry
	ResourceEnquiry getOne(int resourceEnquiryId);
	
	//method to save an enquiry
	void save(ResourceEnquiry resourceEnquiry);
	
	//method to delete a specific enquiry
	ResourceEnquiry deleteByResourceEnquiryId(int resourceEnquiryId);
	
	
}