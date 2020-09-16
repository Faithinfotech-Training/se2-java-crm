package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ResourceEnquiry;

@Repository
public class ManageResEnquiryUpdateDAOImpl implements ManageResEnquiryUpdateDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	public ManageResEnquiryUpdateDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	@Override
	public List<ResourceEnquiry> findAllSortedResourceEnquiry() {
		// create a query 
		Query query = entityManager.createQuery("from ResourceEnquiry order by enquiry_date");
		List<ResourceEnquiry> resourceEnquiries = query.getResultList();
		return resourceEnquiries;
	
	}

	

	@Override
	public List<ResourceEnquiry> findAllResourceEnquiry(Integer resourceEnquiryStatus) {
		
		// create a query 
		System.out.println(resourceEnquiryStatus.toString());
		Query query = entityManager.createQuery("from ResourceEnquiry where status_id = " + resourceEnquiryStatus.toString());
		List<ResourceEnquiry> resourceEnquiries = query.getResultList();
		return resourceEnquiries;
	
	}

}
