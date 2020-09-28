//DAO Layer of Resource Enquiry
package com.example.demo.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;


import com.example.demo.entity.ResourceEnquiry;
import com.example.demo.entity.CourseEnquiryStatusDTO;
import com.example.demo.entity.CourseLeadResponseDTO;
import com.example.demo.entity.EnquiryStatus;

import com.example.demo.entity.ResourceEnquiry;

import com.example.demo.entity.ResourceEnquiry;
import com.example.demo.entity.ResourceEnquiryStatus;
import com.example.demo.entity.ResourceEnquiryStatusDTO;
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

		Query myQuery = entityManager.createQuery("from resource_enquiry");
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
	public String update(ResourceEnquiry resourceEnquiry) {
		// Get the status of enquiry from db
		ResourceEnquiry resourceEnquiryFromDb = entityManager.find(ResourceEnquiry.class, resourceEnquiry.getResourceEnquiryId());
		// If status is received then it can be updated to Interested or Not Interested
		if(resourceEnquiryFromDb.getStatus().getStatusValue().equalsIgnoreCase("Received") && (resourceEnquiry.getStatus().getStatusValue().equalsIgnoreCase("Interested") || resourceEnquiry.getStatus().getStatusValue().equalsIgnoreCase("Not Interested")))
		{
			System.out.println("Heello");
			entityManager.merge(resourceEnquiry);
		}
		// If Interested then status can be changed to Accepted or Rejected.
		else if(resourceEnquiryFromDb.getStatus().getStatusValue().equalsIgnoreCase("Interested") && (resourceEnquiry.getStatus().getStatusValue().equalsIgnoreCase("Accepted") || resourceEnquiry.getStatus().getStatusValue().equalsIgnoreCase("Rejected")))
		{
			System.out.println("22");
			entityManager.merge(resourceEnquiry);
		}
		// If Accepted then it can be changed to Rented.
		else if(resourceEnquiryFromDb.getStatus().getStatusValue().equalsIgnoreCase("Accepted") && resourceEnquiry.getStatus().getStatusValue().equalsIgnoreCase("Rented")) {
			System.out.println("33");
			entityManager.merge(resourceEnquiry);
		}
		// All other conditions are rejected with Error.
		else {
			return "Error: Please check the status before updating. Cannot update from " + resourceEnquiryFromDb.getStatus().getStatusValue() + " "
					+ "to " + resourceEnquiry.getStatus().getStatusValue()
					+ ".\nCorrect Sequence of Updation: Received -> Interested/Not Interested ->"
					+ " Accepted/Rejected -> Rented";
		}
		return "Updated Successfully.";
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
		Query myQuery = entityManager.createQuery("from resource_enquiry where status = " + status);

		// Extract the results
		List<ResourceEnquiry> resourceEnquiries = myQuery.getResultList();

		// Return the resource enquiries list filter by status
		return resourceEnquiries;
	}

	//	Filter to find resource enquiry by status
	@Override
	public List<ResourceEnquiry> findAllResourceEnquiryByResourceType(int resourceType) {

		// Create a query
		//		String query = "Select resource_enquiry.* from resource_enquiry join resources on resource_enquiry.RESOURCE_ID=resources.RESOURCE_ID where resources.resource_type_id=1";
		Query myQuery = entityManager.createQuery("from resource_enquiry");
		List<ResourceEnquiry> resourceEnquiries = myQuery.getResultList();
		List<ResourceEnquiry> filterByResourceTypeEnquiries = new ArrayList<ResourceEnquiry>();
		for(ResourceEnquiry re: resourceEnquiries) {

			ResourceType resourcesType = re.getResourcesId().getResourceType();
			if(resourcesType.getResourceTypeId()==resourceType) {
				filterByResourceTypeEnquiries.add(re);
			}

		}
		// Return the resource enquiries list filter by status
		return filterByResourceTypeEnquiries;
	}

	@Override
	@Modifying
	public List<ResourceEnquiry> viewResourceSalesPipeline()
	{

		Query query= entityManager.createQuery("from resource_enquiry");
		List<ResourceEnquiry> enquiryList=query.getResultList();

		int totalNumberOfEnquiries;

		//Decalring total number of status values;

		int totalNumberOfStatusValues=0;

		// Create list of IDs of status
		List<String> statusList=new ArrayList<String>();
		
		//Count value assignment
		totalNumberOfEnquiries=enquiryList.size();

		System.out.println("Total Number of Resource Enquiries:"+" "+totalNumberOfEnquiries);

		//Iterating over enquiries and checking their status values

		for(int i=0;i<totalNumberOfEnquiries;i++)
		{
			ResourceEnquiry resourceenquiry=enquiryList.get(i);
			if(!(statusList.contains(resourceenquiry.getStatus().getStatusValue())))
			{
				statusList.add(resourceenquiry.getStatus().getStatusValue());
			}
		}

		//Count value assignment
				totalNumberOfStatusValues=statusList.size();
				
		//Print all status values
				for(int i=0;i<totalNumberOfStatusValues;i++)
				{
					System.out.println(statusList.get(i));
				}
				
		System.out.println("Total Number of status Values:"+" "+totalNumberOfStatusValues);

		return  enquiryList;
	}




	@Override
	public List<ResourceEnquiryStatusDTO> viewResourceTable() {
		Query query= entityManager.createQuery("from resource_enquiry");

		int totalNumberOfEnquiries;
		
		//Decalring total number of status values;
		
		int totalNumberOfStatusValues=0;
		
		HashMap<String,Integer> statusMapper=new LinkedHashMap<String,Integer>();
		
		
		// Extract the result from database
		List<ResourceEnquiry> enquiryList=query.getResultList();
		
		query=entityManager.createQuery("from resource_enquiry_status");
		
		List<ResourceEnquiryStatus> enquiryStatusList=query.getResultList();
		
		// Create list of IDs of status
	//	List<String> statusList=new ArrayList<String>();
		
		for(int i=0;i<enquiryStatusList.size();i++)
		{
			statusMapper.put(enquiryStatusList.get(i).getStatusValue(),0);
		}
		
		
		//Count value assignment
		totalNumberOfEnquiries=enquiryList.size();
		
		System.out.println("Total Number of Resource Enquiries:"+" "+totalNumberOfEnquiries);
		
		//Iterating over enquiries and checking their status values
		
		for(int i=0;i<totalNumberOfEnquiries;i++)
		{
			ResourceEnquiry resourceenquiry=enquiryList.get(i);
			
			String status=resourceenquiry.getStatus().getStatusValue();
			
			statusMapper.put(status, statusMapper.get(status)+1);
			
			System.out.println(resourceenquiry);
			
		}
		
		   
		//Count value assignment
	//			totalNumberOfStatusValues=statusList.size();
				
		//Print all status values
		
				
	//	System.out.println("Total Number of status Values:"+" "+totalNumberOfStatusValues);
		List<ResourceEnquiryStatusDTO> resourcestatusList=new ArrayList<ResourceEnquiryStatusDTO>();
		
		for(Map.Entry m:statusMapper.entrySet()){  
			
			ResourceEnquiryStatusDTO resourceEnquiryStatusDTO=new ResourceEnquiryStatusDTO();
	           System.out.println("Status Value:"+m.getKey()+" "+"Status Count:"+m.getValue());  
	           resourceEnquiryStatusDTO.setStatusValue(m.getKey().toString());
	           resourceEnquiryStatusDTO.setStatusCount(Integer.parseInt(m.getValue().toString()));
	          resourcestatusList.add(resourceEnquiryStatusDTO); 
	  
	          }  
		
		return  resourcestatusList;
	}

	// api for filter by date
	@Override
	public List<ResourceEnquiry> findAllResourceEnquiryByDate(String startDate, String endDate) {
		// Create a query
		Query myQuery = entityManager.createQuery("from resource_enquiry where trunc(ENQUIRY_DATE)BETWEEN TO_DATE( '"
				+ startDate + " ') and TO_DATE('" + endDate + "' )");
		// trunc(ENQUIRYDATE)BETWEEN TO_DATE('20-09-27') and TO_DATE('20-09-27')
		// Extract the results
		List<ResourceEnquiry> resourceEnquiries = myQuery.getResultList();

		// Return the resource enquiries list filter by status
		return resourceEnquiries;
	}

	// api for filter by date and status
	@Override
	public List<ResourceEnquiry> findAllResourceEnquiryByDateAndStatus(String startDate, String endDate,int status) {
		// Create a query
		Query myQuery = entityManager.createQuery("from resource_enquiry where (trunc(ENQUIRY_DATE)BETWEEN TO_DATE( '"
				+ startDate + " ') and TO_DATE('" + endDate + "' )) and status_id = " + status );
		
		// Extract the results
		List<ResourceEnquiry> resourceEnquiries = myQuery.getResultList();

		// Return the resource enquiries list filter by status
		return resourceEnquiries;
	}

	// api for count of total
	@Override
	public int findAllResourceEnquiryCount() {
		// Create a query
		Query myQuery = entityManager.createQuery("select count(*) from resource_enquiry ");
		// Extract the results
		int count = ((Number)myQuery.getSingleResult()).intValue();

		// Return the resource enquiries list count
		return count;
	}



	@Override
	public List<CourseLeadResponseDTO> viewLeadSalesPipeline() {

		int totalCount=0;
		HashMap<String,Integer> statusMapper=new LinkedHashMap<String,Integer>();
		List<CourseLeadResponseDTO> list=new ArrayList<CourseLeadResponseDTO>();
		Query query = entityManager.createQuery("select count(*) from resource_enquiry ");
		
		 totalCount = ((Number)query.getSingleResult()).intValue();
	
		  query= entityManager.createQuery("from resource_enquiry");
			
			// Extract the result from database
			List<ResourceEnquiry> enquiryList=query.getResultList();

		 enquiryList.get(0).getCustomerId().getLeadSource();
		 
		 
		 for(int i=0;i<totalCount;i++)
			{
			 
			
				ResourceEnquiry courseenquiry=enquiryList.get(i);
				
			String lead=courseenquiry.getCustomerId().getLeadSource();
				
			if(statusMapper.containsKey(lead))
			{
				statusMapper.put(lead, statusMapper.get(lead)+1);
							
			}
			else
			{
				statusMapper.put(lead,0);
			}
			  
			System.out.println(courseenquiry);
			}
		 for(Map.Entry m:statusMapper.entrySet()){  
				
				CourseLeadResponseDTO dto=new CourseLeadResponseDTO();
		           System.out.println("Status Value:"+m.getKey()+" "+"Status Count:"+m.getValue());  
		           dto.setLead(m.getKey().toString());
		           dto.setLeadCount(Integer.parseInt(m.getValue().toString()));
		           dto.setTotalCount(totalCount);
		          list.add(dto); 
		  
		          }  	 
		 
		return list;
		
			}

}
