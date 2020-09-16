//Service Layer Implementation of Resource Enquiry API

package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ResourceEnquiryDAOImplementation;
import com.example.demo.entity.ResourceEnquiry;



@Service
public class ResourceEnquiryServiceImplementation implements ResourceEnquiryService {

	ResourceEnquiryDAOImplementation resourceEnquiryDAOImplementation;


	
	@Autowired
	public ResourceEnquiryServiceImplementation(ResourceEnquiryDAOImplementation resourceEnquiryDAOImplementation) {
	
		super();
		this.resourceEnquiryDAOImplementation = resourceEnquiryDAOImplementation;
	}


	
// Method for getting all the resource enquiries
	@Override
	public List<ResourceEnquiry> findAllResourceEnquiry() {

		return resourceEnquiryDAOImplementation.findAll();
	}	
	
	

// Method for getting a specific resource enquiry by using Resource Enquiry ID
	@Override
	public ResourceEnquiry findByResourceEnquiryId(int resourceEnquiryId) {

		return resourceEnquiryDAOImplementation.getOne(resourceEnquiryId);
	}


	
// Method to save Resource Enquiry
	@Override
	public void saveResourceEnquiry(ResourceEnquiry resourceEnquiry) {
		
		resourceEnquiryDAOImplementation.save(resourceEnquiry);

	}


	
// Method to delete a resource Enquiry for given Resource Enquiry Id
	@Override
	public void deleteByResourceEnquiryId(int resourceEnquiryId) {

		resourceEnquiryDAOImplementation.deleteByResourceEnquiryId(resourceEnquiryId);
	}


	
// Method to update the status of specific resource Enquiry.
	@Override
	public void updateResourceEnquiry(int resourceEnquiryId, ResourceEnquiry resourceEnquiry) {
		
		ResourceEnquiry enquiry = resourceEnquiryDAOImplementation.getOne(resourceEnquiryId);
		
		if (enquiry.getResourceEnquiryId() != null) {
			
			enquiry.setStatus(resourceEnquiry.getStatus());
			resourceEnquiryDAOImplementation.save(enquiry);
		
		}
	}

}
