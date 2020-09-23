package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
	

//	Check if resourcesDAO is autowired correctly
	@Test
	public void injectedServicesAreNotNull() {
		assertThat(resourceEnquiryService).isNotNull();
	}
	@Test
	public void saveResourceEnquiryTest() {

	
		String dobString="1998-02-04";  
		Date DOB=Date.valueOf(dobString);

		String enquiryDateString="2020-01-30";  
		Date enquiryDate=Date.valueOf(enquiryDateString);

		Customer customer = new Customer(1, "Kaustubh", "Kaustubh@gmail.com", "9099069907", DOB, "BCA", 90, "Website");
		Access access = new Access(1,"active");
		ResourceType resourceType = new ResourceType(1,"Hall");
		ResourceEnquiryStatus status =new ResourceEnquiryStatus(1,"enquired"); 
		Status stat = new Status(1,"available");
		Resources resources = new Resources("Hall","Large Hall",2000,10000,stat,access,resourceType);
	
		ResourceEnquiry resourceEnquiry = new ResourceEnquiry(1, customer, resources, status,enquiryDate);
		resourceEnquiryDAO.save(resourceEnquiry);
		verify(resourceEnquiryDAO,times(1)).save(resourceEnquiry);
	}

	@Test
	public void findAllResourcesTest() {

		String dobString="1998-02-04";  
		Date DOB=Date.valueOf(dobString);
		String enquiryDateString="2020-01-30";  
		Date enquiryDate=Date.valueOf(enquiryDateString);
		Status stat = new Status(1,"Active");
		Access access = new Access(1,"Private");
		ResourceEnquiryStatus status =new ResourceEnquiryStatus(1,"enquired"); 
		ResourceType resourceType = new ResourceType(1,"Hall");
		Customer customer = new Customer(1, "Kaustubh", "Kaustubh@gmail.com", "9099069907", DOB, "BCA", 90, "Website");
		Resources resources = new Resources("ABC hall", "A big hall", 20, 3000, stat, access, resourceType);
		ResourceEnquiry resourceEnquiry = new ResourceEnquiry(1, customer, resources, status,enquiryDate);
		when(resourceEnquiryDAO.findAll()).thenReturn(Stream.of(resourceEnquiry).collect(Collectors.toList()));
		
		assertEquals(1, resourceEnquiryService.findAllResourceEnquiry().size());
		
		
	}
	
	@Test
	public void findAllResourcesByIdTest() {
		String dobString="1998-02-04";  
		Date DOB=Date.valueOf(dobString);
		String enquiryDateString="2020-01-30";  
		Date enquiryDate=Date.valueOf(enquiryDateString);
		Status stat = new Status(1,"Active");
		Access access = new Access(1,"Private");
		ResourceEnquiryStatus status =new ResourceEnquiryStatus(1,"enquired"); 
		ResourceType resourceType = new ResourceType(1,"Hall");
		Customer customer = new Customer(1, "Kaustubh", "Kaustubh@gmail.com", "9099069907", DOB, "BCA", 90, "Website");
		Resources resources = new Resources("ABC hall", "A big hall", 20, 3000, stat, access, resourceType);
		ResourceEnquiry resourceEnquiry = new ResourceEnquiry(1, customer, resources, status,enquiryDate);
		
		when(resourceEnquiryDAO.getOne(1)).thenReturn(resourceEnquiry);

		assertEquals(new Integer(1), resourceEnquiryService.findByResourceEnquiryId(1).getResourceEnquiryId());
	}
	

}
