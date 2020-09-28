package com.example.demo.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CourseEnquiry;
import com.example.demo.entity.CourseEnquiryStatusDTO;
import com.example.demo.entity.CourseLeadResponseDTO;
import com.example.demo.entity.EnquiryStatus;

@Repository
public class CourseEnquiryDAOImpl implements CourseEnquiryDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	public CourseEnquiryDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public void saveCourseEnquiry(CourseEnquiry courseEnquiry) {
		// Save course enquiry
		System.out.println("hello");
		courseEnquiry.setRegistrationId(0);
		entityManager.merge(courseEnquiry);
	}

	@Override
	public List<CourseEnquiry> findAllCourseEnquiry() {

		// Create a query
		Query myQuery = entityManager.createQuery("from course_enquiry");

		// Extract the results
		List<CourseEnquiry> courseEnquiries = myQuery.getResultList();

		// Return the course enquiries list
		return courseEnquiries;
	}

	@Override
	public CourseEnquiry findCourseEnquiryById(Integer id) {
		// Find the courseEnquiry by Id
		CourseEnquiry courseEnquiry = entityManager.find(CourseEnquiry.class, id);
		return courseEnquiry;
	}

	@Override
	public boolean updateCourseEnquiry(CourseEnquiry courseEnquiry) {
		// Update the course enquiry
		entityManager.merge(courseEnquiry);
		return false;
	}

	@Override
	public CourseEnquiry deleteCourseEnquiry(Integer id) {
		// Find CourseEnquiry
		CourseEnquiry courseEnquiry = (CourseEnquiry) entityManager.find(CourseEnquiry.class, id);
		// If CourseEnquiry is present remove else return null
		if (entityManager.contains(courseEnquiry)) {
			entityManager.remove(courseEnquiry);
		} else {
			return null;
		}
		return courseEnquiry;
	}

	@Override
	public List<CourseEnquiry> findAllCourseEnquiryByStatus(int enquiryStatus) {

		// Create a query
		Query myQuery = entityManager.createQuery("from course_enquiry where enquiryStatus = " + enquiryStatus);

		// Extract the results
		List<CourseEnquiry> courseEnquiries = myQuery.getResultList();

		// Return the course enquiries list filter by status
		return courseEnquiries;
	}

	@Override
	@Modifying
	public List<CourseEnquiry> viewCourseSalesPipeline() {
		// Declaring Total Number of Course Enquiries
		int totalNumberOfEnquiries;

		// Decalring total number of status values;

		int totalNumberOfStatusValues = 0;

		Query query = entityManager.createQuery("from course_enquiry");

		// Extract the result from database
		List<CourseEnquiry> enquiryList = query.getResultList();

		// Create list of IDs of status
		List<String> statusList = new ArrayList<String>();

		// Count value assignment
		totalNumberOfEnquiries = enquiryList.size();

		System.out.println("Total Number of Course Enquiries:" + " " + totalNumberOfEnquiries);

		// Iterating over enquiries and checking their status values

		for (int i = 0; i < totalNumberOfEnquiries; i++) {
			CourseEnquiry courseenquiry = enquiryList.get(i);
			System.out.println(courseenquiry);
			if (statusList == null) {

				String status = courseenquiry.getEnquiryStatus().getStatusValue();
				statusList.add(status);

			} else if (!(statusList.contains(courseenquiry.getEnquiryStatus().getStatusValue()))) {
				statusList.add(courseenquiry.getEnquiryStatus().getStatusValue());
			}
		}

		// Count value assignment
		totalNumberOfStatusValues = statusList.size();

		// Print all status values
		for (int i = 0; i < totalNumberOfStatusValues; i++) {

			System.out.println(statusList.get(i));
		}

		System.out.println("Total Number of status Values:" + " " + totalNumberOfStatusValues);

		return enquiryList;
	}

	@Override
	@Modifying

	public List<CourseEnquiryStatusDTO> viewCourseTable() {
	
int totalNumberOfEnquiries;
		
		//Decalring total number of status values;
		
		int totalNumberOfStatusValues=0;
		
		HashMap<String,Integer> statusMapper=new LinkedHashMap<String,Integer>();
		
		Query query= entityManager.createQuery("from course_enquiry");
		
		// Extract the result from database
		List<CourseEnquiry> enquiryList=query.getResultList();
		
		query=entityManager.createQuery("from enquirystatus");
		
		List<EnquiryStatus> enquiryStatusList=query.getResultList();
		
		// Create list of IDs of status
		List<String> statusList=new ArrayList<String>();
		
		for(int i=0;i<enquiryStatusList.size();i++)
		{
			statusMapper.put(enquiryStatusList.get(i).getStatusValue(),0);
		}
		
		
		//Count value assignment
		totalNumberOfEnquiries=enquiryList.size();
		
		System.out.println("Total Number of Course Enquiries:"+" "+totalNumberOfEnquiries);
		
		//Iterating over enquiries and checking their status values
		
		for(int i=0;i<totalNumberOfEnquiries;i++)
		{
			CourseEnquiry courseenquiry=enquiryList.get(i);
			
			String status=courseenquiry.getEnquiryStatus().getStatusValue();
			
			statusMapper.put(status, statusMapper.get(status)+1);
			
			System.out.println(courseenquiry);
			

	
		}
		totalNumberOfStatusValues=statusList.size();
		
		//Print all status values
		
				
		System.out.println("Total Number of status Values:"+" "+totalNumberOfStatusValues);
		List<CourseEnquiryStatusDTO> coursestatusList=new ArrayList<CourseEnquiryStatusDTO>();
		
		for(Map.Entry m:statusMapper.entrySet()){  
			
			CourseEnquiryStatusDTO courseEnquiryStatusDTO=new CourseEnquiryStatusDTO();
	           System.out.println("Status Value:"+m.getKey()+" "+"Status Count:"+m.getValue());  
	           courseEnquiryStatusDTO.setStatusValue(m.getKey().toString());
	           courseEnquiryStatusDTO.setStatusCount(Integer.parseInt(m.getValue().toString()));
	          coursestatusList.add(courseEnquiryStatusDTO); 
	  
	          }  
		
		return  coursestatusList;
	
	}

	// api for filter by date
	@Override
	public List<CourseEnquiry> findAllCourseEnquiryByDate(String startDate, String endDate) {
		// Create a query
		Query myQuery = entityManager.createQuery("from course_enquiry where trunc(ENQUIRYDATE) BETWEEN TO_DATE( '"
				+ startDate + " ') and TO_DATE('" + endDate + "' )");
		// trunc(ENQUIRYDATE)BETWEEN TO_DATE('20-09-27') and TO_DATE('20-09-27')
		// Extract the results
		List<CourseEnquiry> courseEnquiries = myQuery.getResultList();

		// Return the course enquiries list filter by status
		return courseEnquiries;
	}

	// api for filter by date and status
	@Override
	public List<CourseEnquiry> findAllCourseEnquiryByDateAndStatus(String startDate, String endDate,int status) {
		// Create a query
		Query myQuery = entityManager.createQuery("from course_enquiry where (trunc(ENQUIRYDATE)BETWEEN TO_DATE( '"
				+ startDate + " ') and TO_DATE('" + endDate + "' )) and status_id = " + status );

		   
		//Count value assignment
				
// Extract the results
		List<CourseEnquiry> courseEnquiries = myQuery.getResultList();

		// Return the course enquiries list filter by status
		return courseEnquiries;

	}

	// api for count of total
	@Override
	public int findAllCourseEnquiryCount() {
		// Create a query
		Query myQuery = entityManager.createQuery("select count(*) from course_enquiry ");
		// Extract the results
		int count = ((Number)myQuery.getSingleResult()).intValue();

		// Return the course enquiries list count
		return count;
	}

	@Override
	public List<CourseLeadResponseDTO> viewCourseLeadSalesPipeline() {
	
		int totalCount=0;
		HashMap<String,Integer> statusMapper=new LinkedHashMap<String,Integer>();
		List<CourseLeadResponseDTO> list=new ArrayList<CourseLeadResponseDTO>();
		Query query = entityManager.createQuery("select count(*) from course_enquiry ");
		
		 totalCount = ((Number)query.getSingleResult()).intValue();
	
		  query= entityManager.createQuery("from course_enquiry");
			
			// Extract the result from database
			List<CourseEnquiry> enquiryList=query.getResultList();

		 enquiryList.get(0).getCustomerId().getLeadSource();
		 
		 
		 for(int i=0;i<totalCount;i++)
			{
			
				CourseEnquiry courseenquiry=enquiryList.get(i);
				
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
