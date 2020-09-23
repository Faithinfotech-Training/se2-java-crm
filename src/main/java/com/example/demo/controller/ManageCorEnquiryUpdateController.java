package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CourseEnquiry;
import com.example.demo.service.ManageCorEnquiryUpdateService;

@RestController
@RequestMapping("/api/enquiry")
public class ManageCorEnquiryUpdateController {

	@Autowired
	private ManageCorEnquiryUpdateService manageCorEnquiryUpdateService;

	// Get a list of courses sorted on the basis of date.
	@GetMapping("/course/priority")
	public ResponseEntity findAllResourceEnquiry() {
		List<CourseEnquiry> listOfCourseEnquiries = manageCorEnquiryUpdateService.findAllSortedCourseEnquiry();
		if (listOfCourseEnquiries == null)
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(listOfCourseEnquiries);
	}

	// return list of enquiries of parameterised type
	@GetMapping("/course/status/{id}")
	public ResponseEntity findAllCourseEnquiry(@PathVariable("id") Integer EnquiryStatus) {
		List<CourseEnquiry> listOfCourseEnquiries = manageCorEnquiryUpdateService.findAllCourseEnquiry(EnquiryStatus);
		if (listOfCourseEnquiries == null)
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(listOfCourseEnquiries);
	}

}
