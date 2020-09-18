//DAO Layer of Resource Enquiry
package com.example.demo.dao;

import java.util.ArrayList;
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
import com.example.demo.entity.ResourceType;
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

	@Override
	public boolean update(ResourceEnquiry resourceEnquiry) {
		entityManager.merge(resourceEnquiry);
		return false;
	}

	
	// Method to delete a specific resource
	@Override
	
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

		resourceEnquiry.setResourceEnquiryId(0);
		entityManager.merge(resourceEnquiry);
	}

	
	
//	Filter to find resource enquiry by status
	@Override
    public List<ResourceEnquiry> findAllResourceEnquiryByStatus(int status) {

        // Create a query
        Query myQuery = entityManager.createQuery("from ResourceEnquiry where status = " + status);

        // Extract the results
        List<ResourceEnquiry> courseEnquiries = myQuery.getResultList();

        // Return the course enquiries list filter by status
        return courseEnquiries;
    }
	
//	Filter to find resource enquiry by status
	@Override
    public List<ResourceEnquiry> findAllResourceEnquiryByResourceType(int resourceType) {

        // Create a query
//		String query = "Select resource_enquiry.* from resource_enquiry join resources on resource_enquiry.RESOURCE_ID=resources.RESOURCE_ID where resources.resource_type_id=1";
		Query myQuery = entityManager.createQuery("from ResourceEnquiry");
		List<ResourceEnquiry> resourceEnquiries = myQuery.getResultList();
		List<ResourceEnquiry> filterByResourceTypeEnquiries = new ArrayList<ResourceEnquiry>();
		for(ResourceEnquiry re: resourceEnquiries) {
			
			ResourceType resourcesType = re.getResourcesId().getResourceType();
			if(resourcesType.getResourceTypeId()==resourceType) {
				filterByResourceTypeEnquiries.add(re);
			}
			
		}
        // Return the course enquiries list filter by status
        return filterByResourceTypeEnquiries;
    }






}
