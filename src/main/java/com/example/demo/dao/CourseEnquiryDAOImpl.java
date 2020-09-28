package com.example.demo.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Course;
import com.example.demo.entity.CourseEnquiry;
import com.example.demo.entity.Customer;
import com.example.demo.entity.EnquiryStatus;
import com.example.demo.entity.Qualification;

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
	public String updateCourseEnquiry(CourseEnquiry courseEnquiry) {
		// Update the course enquiry
		CourseEnquiry courseEnquiryFromDb = entityManager.find(CourseEnquiry.class,courseEnquiry.getRegistrationId());
		// If status is received then it can be updated to Interested or Not Interested
			if(courseEnquiryFromDb.getEnquiryStatus().getStatusValue().equalsIgnoreCase("Received") && (courseEnquiry.getEnquiryStatus().getStatusValue().equalsIgnoreCase("Interested") || courseEnquiry.getEnquiryStatus().getStatusValue().equalsIgnoreCase("Not Interested")))
				{
					System.out.println("Heello");
					entityManager.merge(courseEnquiry);
				}
				// If Interested then status can be changed to Accepted or Rejected.
				else if(courseEnquiryFromDb.getEnquiryStatus().getStatusValue().equalsIgnoreCase("Interested") && (courseEnquiry.getEnquiryStatus().getStatusValue().equalsIgnoreCase("Registered")))
				{
					System.out.println("22");
					entityManager.merge(courseEnquiry);
				}
				// If Accepted then it can be changed to Rented.
				else if(courseEnquiryFromDb.getEnquiryStatus().getStatusValue().equalsIgnoreCase("Registered") && courseEnquiry.getEnquiryStatus().getStatusValue().equalsIgnoreCase("Test Taken")) {
					System.out.println("33");
					entityManager.merge(courseEnquiry);
				}
				
				else if(courseEnquiryFromDb.getEnquiryStatus().getStatusValue().equalsIgnoreCase("Test Taken") && courseEnquiry.getEnquiryStatus().getStatusValue().equalsIgnoreCase("Qualified")) {
					System.out.println("44");
					entityManager.merge(courseEnquiry);
				}
				else if(courseEnquiryFromDb.getEnquiryStatus().getStatusValue().equalsIgnoreCase("Qualified") && courseEnquiry.getEnquiryStatus().getStatusValue().equalsIgnoreCase("Admission")) {
						System.out.println("55");
					int flag =0;
					Course course = courseEnquiryFromDb.getCourseId();	
					Customer customer = courseEnquiryFromDb.getCustomerId();
					Set<Qualification> set = course.getQualifications(); 
					for (Iterator<Qualification> it = set.iterator(); it.hasNext(); ) {
				        Qualification f = it.next();
				        if (f.getQualificationName().equals(customer.getCustomerQualification()))
				        { 	System.out.println("Qualification Matched" );
				        	if(Integer.parseInt(f.getPercentage()) <= customer.getCustomerPercentage())
				        		{System.out.println("Percentage Matched");
				        		flag=1;
				        		}
				        }
				       
				    }
					if(flag == 1 )
					{
						System.out.println("success in addmision");
						entityManager.merge(courseEnquiry);
					}
					else return "Cannot Admit";
					//get all the qualifications of courses from set to arraylist; 
					// check arraylist contains customer qualification.
					// if contains then check the percentage.
					
				}
				// All other conditions are rejected with Error.
				else {
					return "Error: Please check the status before updating. Cannot update from " + courseEnquiryFromDb.getEnquiryStatus().getStatusValue() + " "
							+ "to " + courseEnquiry.getEnquiryStatus().getStatusValue()
							+ ".\nCorrect Sequence of Updation: Received -> Interested/Not Interested ->"
							+ " Registered -> Test taken -> Qualified -> Admission";
				}
				
		return "Updated Successfully.";
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
	public List<CourseEnquiry> viewCourseTable() {

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

}
