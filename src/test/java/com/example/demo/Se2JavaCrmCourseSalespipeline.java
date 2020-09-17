package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
import com.example.demo.service.CSalespipelineService;
import com.example.demo.service.RSalespipeline;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Se2JavaCrmCourseSalespipeline {
	
	public class Se2JavaCrmSalesResourcepipelineTest {
		
		@Autowired
		private CSalespipelineService cSalesPipelineService;
		
		
		@MockBean
		private CourseEnquiryDAO courseEnquiryDAO;
		

//		Check if resourcesDAO is autowired correctly
		@Test
		public void injectedServicesAreNotNull() {
			assertThat(cSalesPipelineService).isNotNull();
		}

		
		@Test
		public void viewCourseSalesPipelineTest() {

			Integer theId=new Integer(1);
			String dobString="1998-01-30";  
			Date DOB=Date.valueOf(dobString);

			String enquiryDateString="2020-01-30";  
			Date enquiryDate=Date.valueOf(enquiryDateString);

			Customer customer = new Customer(1, "trupti", "trupti@gmail.com", "1234567890", DOB, "Btech", 90, "Website");
			Course course = new Course();
			EnquiryStatus enquiryStatus = new EnquiryStatus(1, "Called");
			CourseEnquiry courseEnquiry = new CourseEnquiry(1, customer, course, enquiryDate, enquiryStatus);
			courseEnquiryDAO.viewCourseSalesPipeline();
			assertEquals(1,cSalesPipelineService.viewCourseSalesPipeline().size());
			
		}
		
		

	}

}
