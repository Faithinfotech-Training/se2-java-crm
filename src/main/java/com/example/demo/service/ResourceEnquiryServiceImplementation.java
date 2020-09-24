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
