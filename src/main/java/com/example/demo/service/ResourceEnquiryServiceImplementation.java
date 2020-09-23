<<<<<<< HEAD
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



	@Override
	public List<ResourceEnquiry> findAllResourceEnquiryByStatus(int status) {
		// TODO Auto-generated method stub
		return resourceEnquiryDAOImplementation.findAllResourceEnquiryByStatus(status);
	}



	@Override
	public List<ResourceEnquiry> findAllResourceEnquiryByResourceType(int resourceType) {
		// TODO Auto-generated method stub
		return resourceEnquiryDAOImplementation.findAllResourceEnquiryByResourceType(resourceType);
	}

}
=======
//Service Layer Implementation of Resource Enquiry API

package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

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
	@Transactional
	public List<ResourceEnquiry> findAllResourceEnquiry() {

		return resourceEnquiryDAO.findAll();
	}	



	// Method for getting a specific resource enquiry by using Resource Enquiry ID
	@Override
	@Transactional
	public ResourceEnquiry findByResourceEnquiryId(int resourceEnquiryId) {

		return resourceEnquiryDAO.getOne(resourceEnquiryId);
	}



	// Method to save Resource Enquiry
	@Override
	@Transactional
	public void saveResourceEnquiry(ResourceEnquiry resourceEnquiry) {
		resourceEnquiry.setResourceEnquiryId(0);
		resourceEnquiryDAO.save(resourceEnquiry);

	}



	// Method to delete a resource Enquiry for given Resource Enquiry Id
	@Override
	@Transactional
	public void deleteByResourceEnquiryId(int resourceEnquiryId) {

		resourceEnquiryDAO.deleteByResourceEnquiryId(resourceEnquiryId);
	}



	// Method to update the status of specific resource Enquiry.
	@Override
	@Transactional
	public String updateResourceEnquiry(ResourceEnquiry resourceEnquiry) {
		return resourceEnquiryDAO.update(resourceEnquiry);

	}



	@Override
	@Transactional
	public List<ResourceEnquiry> findAllResourceEnquiryByStatus(int status) {
		return resourceEnquiryDAO.findAllResourceEnquiryByStatus(status);
	}



	@Override
	@Transactional
	public List<ResourceEnquiry> findAllResourceEnquiryByResourceType(int resourceType) {
		return resourceEnquiryDAO.findAllResourceEnquiryByResourceType(resourceType);
	}

}
>>>>>>> 5f19ed8f8d38ffa3256101883bb0c8f6c5603409
