package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CourseEnquiry;
import com.example.demo.entity.EnquiryStatus;
import com.example.demo.service.CourseEnquiryService;
import com.example.demo.service.EnquiryStatusService;

@RestController
@RequestMapping("/api/enquiry")
public class EnquiryStatusController {

	// EnquiryStatusService to access functions
	@Autowired
	private EnquiryStatusService enquiryStatusService;
	
	// List all the enquiry statuses
	@GetMapping("/coursestatus")
	public ResponseEntity findAllEnuiryStatuses()
	{
		List<EnquiryStatus> listOfEnquiryStatuses = enquiryStatusService.findAllEnquiryStatus(); 
		if(listOfEnquiryStatuses == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(listOfEnquiryStatuses);
	}
	
	/*
	 * Returns the Enquiry Status of particular Id
	 */
	@GetMapping("/coursestatus/{statusId}")
	public ResponseEntity findByIdStatusEnquiry(@PathVariable("statusId") Integer statusId) {
		EnquiryStatus enquiryStatus = enquiryStatusService.findEnquiryStatusById(statusId);
		if(enquiryStatus == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(enquiryStatus);
	}
	

	// Create an enquiry status
	 @RequestMapping(value = "/coursestatus", method = RequestMethod.POST)
	public ResponseEntity<String> saveEnquiryStatus(@RequestBody EnquiryStatus enquiryStatus) {
		enquiryStatusService.saveEnquiryStatus(enquiryStatus);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
			
	//Update the enquiry status
	 @PutMapping("/coursestatus")
	 public ResponseEntity updateEnquiryStatus(@RequestBody EnquiryStatus enquiryStatus) {
		 enquiryStatusService.updateEnquiryStatus(enquiryStatus);
		 return ResponseEntity.ok().build();
	 }
	 
	// Delete the enquiry status
	@DeleteMapping("/coursestatus/{statusId}")
	public ResponseEntity<Object> deleteById(@PathVariable("statusId") int id ) {
		EnquiryStatus enquiryStatus = enquiryStatusService.deleteEnquiryStatus(id);
		if(enquiryStatus == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		return ResponseEntity.ok(enquiryStatus);
	}
}
