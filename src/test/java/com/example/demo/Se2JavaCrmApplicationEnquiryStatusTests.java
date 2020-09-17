package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.EnquiryStatusDAO;
import com.example.demo.entity.CourseEnquiry;
import com.example.demo.entity.EnquiryStatus;
import com.example.demo.service.EnquiryStatusService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Se2JavaCrmApplicationEnquiryStatusTests {

	@Autowired
	private EnquiryStatusService enquiryStatusService;
	
	@MockBean
	private EnquiryStatusDAO enquiryStatusDAO;

	@Test
	public void findByIdEnquiryStatusTest() {
		Integer id = new Integer(1);
		EnquiryStatus enquiryStatus = new EnquiryStatus(1, "Called");
		when(enquiryStatusDAO.findEnquiryStatusById(id)).thenReturn(enquiryStatus);
		assertEquals(new Integer(1), enquiryStatusService.findEnquiryStatusById(id).getStatusId());

	}
	
	@Test
	public void findAllEnquiryStatusTest() {
		EnquiryStatus enquiryStatus = new EnquiryStatus(1, "Called");
		when(enquiryStatusDAO.findAllEnquiryStatus()).thenReturn(Stream
				.of(enquiryStatus)
				.collect(Collectors.toList()));
		assertEquals(1, enquiryStatusService.findAllEnquiryStatus().size());

	}
	
	@Test
	public void saveEnquiryStatusTest() {
		EnquiryStatus enquiryStatus = new EnquiryStatus(1, "Called");
		enquiryStatusDAO.saveEnquiryStatus(enquiryStatus);
		verify(enquiryStatusDAO,times(1)).saveEnquiryStatus(enquiryStatus);
	}
	
	
}
