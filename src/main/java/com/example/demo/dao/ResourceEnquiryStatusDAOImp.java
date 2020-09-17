package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.EnquiryStatus;
import com.example.demo.entity.ResourceEnquiryStatus;

@Repository
public class ResourceEnquiryStatusDAOImp implements ResourceEnquiryStatusDAO{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	public ResourceEnquiryStatusDAOImp(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public void saveEnquiryStatus(ResourceEnquiryStatus resourceEnquiryStatus) {
		resourceEnquiryStatus.setStatusId(0);
		entityManager.merge(resourceEnquiryStatus);
	}

	@Override
	public List<ResourceEnquiryStatus> findAllEnquiryStatus() {
		Query myQuery = entityManager.createQuery("from ResourceEnquiryStatus");
		// extract the results
		List<ResourceEnquiryStatus> enquiryStatuses = myQuery.getResultList();	
		// return the course enquiries list
		return enquiryStatuses;

	}

	@Override
	public ResourceEnquiryStatus findEnquiryStatusById(Integer id) {

		// find the enquiry status  by id
		ResourceEnquiryStatus resourceEnquiryStatus = entityManager.find(ResourceEnquiryStatus.class, id);
		return resourceEnquiryStatus;
	}

	@Override
	public boolean updateEnquiryStatus(ResourceEnquiryStatus resourceEnquiryStatus) {
		entityManager.merge(resourceEnquiryStatus);
		return true;
	}

	@Override
	public ResourceEnquiryStatus deleteEnquiryStatus(Integer id) {
		//Find CourseEnquiry
				ResourceEnquiryStatus enquiryStatus = (ResourceEnquiryStatus) entityManager.find(ResourceEnquiryStatus.class, id);
				// If CourseEnquiry is present remove else return null
				if (entityManager.contains(enquiryStatus)) {
					entityManager.remove(enquiryStatus);
				} else {
					return null;
				}
				return enquiryStatus;
	}



}
