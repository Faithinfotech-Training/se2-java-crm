package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ResourceEnquiryStatus;
import com.example.demo.service.ResourceEnquiryStatusService;

@RestController
@RequestMapping("/api/enquiry")
public class ResourceEnquiryStatusController {
	@Autowired
	private ResourceEnquiryStatusService enquiryStatusService;

	@GetMapping("/resourcestatus")
	public ResponseEntity findAllResourceEnuiryStatuses() {
		List<ResourceEnquiryStatus> listOfEnquiryStatuses = enquiryStatusService.findAllResourceEnquiryStatus();
		if (listOfEnquiryStatuses == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(listOfEnquiryStatuses);
	}

	@GetMapping("/resourcestatus/{statusid}")
	public ResponseEntity findByIdResourceStatusEnquiry(@PathVariable("statusid") Integer statusId) {
		ResourceEnquiryStatus enquiryStatus = enquiryStatusService.findResourceEnquiryStatusById(statusId);
		if (enquiryStatus == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(enquiryStatus);
	}

	// Create an enquiry status
	@RequestMapping(value = "/resourcestatus", method = RequestMethod.POST)
	public ResponseEntity<String> saveEnquiryStatus(@RequestBody ResourceEnquiryStatus enquiryStatus) {
		enquiryStatusService.saveResourceEnquiryStatus(enquiryStatus);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	// Update the enquiry status
	@PutMapping("/resourcestatus")
	public ResponseEntity updateEnquiryStatus(@RequestBody ResourceEnquiryStatus enquiryStatus) {
		enquiryStatusService.updateResourceEnquiryStatus(enquiryStatus);
		return ResponseEntity.ok().build();
	}

	// Delete the enquiry status
	@DeleteMapping("/resourcestatus/{statusid}")
	public ResponseEntity<Object> deleteById(@PathVariable("statusid") int id) {
		ResourceEnquiryStatus enquiryStatus = enquiryStatusService.deleteEnquiryStatus(id);
		if (enquiryStatus == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		return ResponseEntity.ok(enquiryStatus);
	}

}
