package com.example.demo;

import static org.junit.Assert.assertEquals;
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
import com.example.demo.entity.Access;
import com.example.demo.entity.Course;
import com.example.demo.entity.CourseEnquiry;
import com.example.demo.entity.Customer;
import com.example.demo.entity.EnquiryStatus;
import com.example.demo.service.CourseEnquiryService;



@RunWith(SpringRunner.class)
@SpringBootTest
class Se2JavaCrmApplicationCourseEnquiryTests {

	@Autowired
	private CourseEnquiryService courseEnquiryService;
	@MockBean
	private CourseEnquiryDAO courseEnquiryDAO;


	@Test
	public void saveCourseEnquiryTest() {
		String dobString="1998-01-30";  
		Date DOB=Date.valueOf(dobString);
		String enquiryDateString="2020-01-30";  
		Date enquiryDate=Date.valueOf(enquiryDateString);
		Customer customer = new Customer(1, "Ronit", "ronit@gmail.com", "1234567890", DOB, "Btech", 90, "Website");
		Course course = new Course();
		EnquiryStatus enquiryStatus = new EnquiryStatus(1, "Called");
		CourseEnquiry courseEnquiry = new CourseEnquiry(1, customer, course, enquiryDate, enquiryStatus);
		courseEnquiryDAO.saveCourseEnquiry(courseEnquiry);
		verify(courseEnquiryDAO,times(1)).saveCourseEnquiry(courseEnquiry);
	}

	@Test
	public void findAllCourseEnquiryTest() {
		String dobString="1998-01-30";  
		Date DOB=Date.valueOf(dobString);
		String enquiryDateString="2020-01-30";  
		Date enquiryDate=Date.valueOf(enquiryDateString);
		Customer customer = new Customer(1, "Ronit", "ronit@gmail.com", "1234567890", DOB, "Btech", 90, "Website");
		EnquiryStatus enquiryStatus = new EnquiryStatus(1, "Called");
		Course course = new Course();
		CourseEnquiry courseEnquiry = new CourseEnquiry(1, customer, course, enquiryDate, enquiryStatus);
		when(courseEnquiryDAO.findAllCourseEnquiry()).thenReturn(Stream
				.of(courseEnquiry)
				.collect(Collectors.toList()));
		assertEquals(1, courseEnquiryService.findAllCourseEnquiry().size());

	}

	@Test
	public void findByIdCourseEnquiryTest() {
		Integer theId=new Integer(1);
		String enquiryDateString="2020-01-30";  
		Date enquiryDate=Date.valueOf(enquiryDateString);
		Customer customer = new Customer();
		EnquiryStatus enquiryStatus = new EnquiryStatus(1, "Called");
		Course course = new Course();
		CourseEnquiry courseEnquiry = new CourseEnquiry(0, customer, course, enquiryDate, enquiryStatus);
		when(courseEnquiryDAO.findCourseEnquiryById(theId)).thenReturn(courseEnquiry);
		System.out.println(courseEnquiryService.findCourseEnquiryById(theId));
		assertEquals(new Integer(0), courseEnquiryService.findCourseEnquiryById(theId).getRegistrationId());
	}


}
