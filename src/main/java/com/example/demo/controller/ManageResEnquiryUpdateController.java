package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ResourceEnquiry;
import com.example.demo.service.ManageResEnquiryUpdateService;

@RestController
@RequestMapping("/api/enquiry")
public class ManageResEnquiryUpdateController {
	
	// Create a Instance of ManageResEnquiryUpdateService to access the service functions
	@Autowired
	private ManageResEnquiryUpdateService manageResEnquiryUpdateService;
	
	// return sorted list of resource enquiries based on date
	@GetMapping("/resource/priority")
	public ResponseEntity findAllResourceEnquiry() {
		List<ResourceEnquiry> listOfResourceEnquiries = manageResEnquiryUpdateService.findAllSortedResourceEnquiry();
		if(listOfResourceEnquiries == null)
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(listOfResourceEnquiries);
	}
	
	//return list of enquiries of parameterised type
	@GetMapping("/resource/{resourceType}")
	public ResponseEntity findAllResourceEnquiry(@PathVariable("resourceType") String resourceEnquiryStatus) {
		List<ResourceEnquiry> listOfResourceEnquiries = manageResEnquiryUpdateService.findAllResourceEnquiry(resourceEnquiryStatus);
		if(listOfResourceEnquiries == null)
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(listOfResourceEnquiries);
	}
	
	
}
