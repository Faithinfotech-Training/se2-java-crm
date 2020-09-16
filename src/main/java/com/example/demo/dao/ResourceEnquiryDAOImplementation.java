//DAO Layer of Resource Enquiry
package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ResourceEnquiry;
import com.example.demo.entity.Resources;


@Repository
public class ResourceEnquiryDAOImplementation implements ResourceEnquiryDAO {

	EntityManager entityManager;


	@Autowired
	public ResourceEnquiryDAOImplementation(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	
	
	// Method to get all the resource enquires
	@Override
	public List<ResourceEnquiry> findAll() {
	
		Query myQuery = entityManager.createQuery("from ResourceEnquiry");
		List<ResourceEnquiry> resourceEnquiries = myQuery.getResultList();
		return resourceEnquiries;
	}

	
	
	// Method to get one resource
	@Override
	public ResourceEnquiry getOne(int resourceEnquiryId) {
	
		ResourceEnquiry resourceEnquiry = entityManager.find(ResourceEnquiry.class, resourceEnquiryId);
		return resourceEnquiry;
	}

	
	
	// Method to delete a specific resource
	@Override
	@Transactional
	public ResourceEnquiry deleteByResourceEnquiryId(int resourceEnquiryId) {

		ResourceEnquiry resourceEnquiry = (ResourceEnquiry) entityManager.find(ResourceEnquiry.class,
				resourceEnquiryId);

		if (entityManager.contains(resourceEnquiry)) {
			entityManager.remove(resourceEnquiry);
		} else {
			return null;
		}
		return resourceEnquiry;
	}

	
	
	// Method to save a Resource Enquiry
	@Override
	@Transactional
	public void save(ResourceEnquiry resourceEnquiry) {

		ResourceEnquiry dbResources = entityManager.merge(resourceEnquiry);
		resourceEnquiry.setResourceEnquiryId(dbResources.getResourceEnquiryId());
	}



}
