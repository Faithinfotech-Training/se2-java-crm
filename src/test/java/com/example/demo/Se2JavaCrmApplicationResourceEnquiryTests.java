package com.example.demo;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.CourseEnquiryDAO;
import com.example.demo.dao.ResourceEnquiryDAO;
import com.example.demo.entity.Access;
import com.example.demo.entity.Course;
import com.example.demo.entity.CourseEnquiry;
import com.example.demo.entity.Customer;
import com.example.demo.entity.EnquiryStatus;
import com.example.demo.entity.ResourceEnquiry;
import com.example.demo.entity.ResourceEnquiryStatus;
import com.example.demo.entity.ResourceType;
import com.example.demo.entity.Resources;
import com.example.demo.entity.Status;
import com.example.demo.service.CourseEnquiryService;
import com.example.demo.service.ResourceEnquiryService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Se2JavaCrmApplicationResourceEnquiryTests {
	@Autowired
	private ResourceEnquiryService resourceEnquiryService;
	@MockBean
	private ResourceEnquiryDAO resourceEnquiryDAO;
	

	@Test
	public void saveResourceEnquiryTest() {

		Integer theId=new Integer(1);
		String dobString="1998-01-30";  
		Date DOB=Date.valueOf(dobString);

		String enquiryDateString="2020-01-30";  
		Date enquiryDate=Date.valueOf(enquiryDateString);

		Customer customer = new Customer(1, "Ronit", "ronit@gmail.com", "1234567890", DOB, "Btech", 90, "Website");
		Access access = new Access();
		ResourceType resourceType = new ResourceType();
		ResourceEnquiryStatus status =new ResourceEnquiryStatus(); 
		Status stat = new Status();
		Resources resources = new Resources("Hall","Large Hall",2000,10000,stat,access,resourceType);
		EnquiryStatus enquiryStatus = new EnquiryStatus(1, "Called");
		ResourceEnquiry resourceEnquiry = new ResourceEnquiry(1, customer, resources, status,enquiryDate);
		resourceEnquiryDAO.save(resourceEnquiry);
		verify(resourceEnquiryDAO,times(1)).save(resourceEnquiry);
	}


}
