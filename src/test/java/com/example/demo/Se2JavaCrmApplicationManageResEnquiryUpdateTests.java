package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.ManageResEnquiryUpdateDAO;
import com.example.demo.entity.ResourceEnquiry;
import com.example.demo.service.ManageResEnquiryUpdateService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Se2JavaCrmApplicationManageResEnquiryUpdateTests {

	@Autowired
	private ManageResEnquiryUpdateService manageResEnquiryUpdateService;
	
	@MockBean
	private ManageResEnquiryUpdateDAO manageResEnquiryUpdateDAO;
	
	@Test
	public void findSortedResourceEnquiryTest() {
		
		ResourceEnquiry resourceEnquiry = new ResourceEnquiry();
		when(manageResEnquiryUpdateDAO.findAllSortedResourceEnquiry()).thenReturn(Stream
				.of(resourceEnquiry)
				.collect(Collectors.toList()));
		assertEquals(1, manageResEnquiryUpdateDAO.findAllSortedResourceEnquiry().size());
	}
	
	@Test
	public void findByStatusResourceEnquiryTest() {
		Integer resourceEnquiryStatus = new Integer(1);
		ResourceEnquiry resourceEnquiry1 = new ResourceEnquiry();
		ResourceEnquiry resourceEnquiry2 = new ResourceEnquiry();
		when(manageResEnquiryUpdateDAO.findAllResourceEnquiry(resourceEnquiryStatus)).thenReturn(Stream
				.of(resourceEnquiry1, resourceEnquiry2).collect(Collectors.toList()));
		assertEquals(2, manageResEnquiryUpdateDAO.findAllResourceEnquiry(resourceEnquiryStatus).size());
	}
	
	
}
