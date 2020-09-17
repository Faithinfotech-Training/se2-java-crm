
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
import com.example.demo.service.RSalespipeline;
import com.example.demo.service.ResourceEnquiryService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Se2JavaCrmSalesResourcepipelineTest {
	
	@Autowired
	private RSalespipeline rSalesPipelineService;
	
	
	@MockBean
	private ResourceEnquiryDAO resourceEnquiryDAO;
	

//	Check if resourcesDAO is autowired correctly
	@Test
	public void injectedServicesAreNotNull() {
		assertThat(rSalesPipelineService).isNotNull();
	}

	@Test
	public void viewResourcesSalesPipelineTest() {

		String dobString="1999-09-01";  
		Date DOB=Date.valueOf(dobString);
		String enquiryDateString="2016-02-21";  
		Date enquiryDate=Date.valueOf(enquiryDateString);
		Status stat = new Status(1,"Active");
		Access access = new Access(1,"Public");
		ResourceEnquiryStatus status =new ResourceEnquiryStatus(1,"called"); 
		ResourceType resourceType = new ResourceType(1,"Hall");
		Customer customer = new Customer(1, "Trupti", "trupti@gmail.com", "9423702099", DOB, "BCA", 90, "Website");
		Resources resources = new Resources("ABC hall", "A big hall", 20, 3000, stat, access, resourceType);
		ResourceEnquiry resourceEnquiry = new ResourceEnquiry(1, customer, resources, status,enquiryDate);
		when(resourceEnquiryDAO.viewResourceSalesPipeline()).thenReturn(Stream.of(resourceEnquiry).collect(Collectors.toList()));
		
		assertEquals(1, rSalesPipelineService.viewResourcesSalesPipeline().size());
		
		
	}
	
	

}

