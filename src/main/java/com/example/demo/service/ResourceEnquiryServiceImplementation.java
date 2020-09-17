//Service Layer Implementation of Resource Enquiry API

package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ResourceEnquiryDAO;
import com.example.demo.dao.ResourceEnquiryDAOImplementation;
import com.example.demo.entity.ResourceEnquiry;



@Service
public class ResourceEnquiryServiceImplementation implements ResourceEnquiryService {

	ResourceEnquiryDAO resourceEnquiryDAO;


	
	@Autowired
	public ResourceEnquiryServiceImplementation(ResourceEnquiryDAO resourceEnquiryDAO) {
	
		super();
		this.resourceEnquiryDAO = resourceEnquiryDAO;
	}


	
// Method for getting all the resource enquiries
	@Override
	public List<ResourceEnquiry> findAllResourceEnquiry() {

		return resourceEnquiryDAO.findAll();
	}	
	
	

// Method for getting a specific resource enquiry by using Resource Enquiry ID
	@Override
	public ResourceEnquiry findByResourceEnquiryId(int resourceEnquiryId) {

		return resourceEnquiryDAO.getOne(resourceEnquiryId);
	}


	
// Method to save Resource Enquiry
	@Override
	public void saveResourceEnquiry(ResourceEnquiry resourceEnquiry) {
		
		resourceEnquiryDAO.save(resourceEnquiry);

	}


	
// Method to delete a resource Enquiry for given Resource Enquiry Id
	@Override
	public void deleteByResourceEnquiryId(int resourceEnquiryId) {

		resourceEnquiryDAO.deleteByResourceEnquiryId(resourceEnquiryId);
	}


	
// Method to update the status of specific resource Enquiry.
	@Override
	public void updateResourceEnquiry(int resourceEnquiryId, ResourceEnquiry resourceEnquiry) {
		
		ResourceEnquiry enquiry = resourceEnquiryDAO.getOne(resourceEnquiryId);
		
		if (enquiry.getResourceEnquiryId() != null) {
			
			enquiry.setStatus(resourceEnquiry.getStatus());
			resourceEnquiryDAO.save(enquiry);
		
		}
	}



	@Override
	public List<ResourceEnquiry> findAllResourceEnquiryByStatus(int status) {
		// TODO Auto-generated method stub
		return resourceEnquiryDAO.findAllResourceEnquiryByStatus(status);
	}



	@Override
	public List<ResourceEnquiry> findAllResourceEnquiryByResourceType(int resourceType) {
		// TODO Auto-generated method stub
		return resourceEnquiryDAO.findAllResourceEnquiryByResourceType(resourceType);
	}

}
