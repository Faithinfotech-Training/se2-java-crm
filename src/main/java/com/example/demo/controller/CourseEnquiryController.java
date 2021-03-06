package com.example.demo.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import com.example.demo.service.CourseEnquiryService;

@CrossOrigin
@RestController
@RequestMapping("/api/enquiry")
public class CourseEnquiryController {

	// CourseEnquiryService to access functions
	@Autowired
	private CourseEnquiryService courseEnquiryService;
	
	// List all the course enquiries
	@GetMapping("/course")
	public ResponseEntity findAllCourseEnquiry()
	{
		List<CourseEnquiry> listOfCourseEnquiries = courseEnquiryService.findAllCourseEnquiry();
		if(listOfCourseEnquiries == null)
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(listOfCourseEnquiries);
	}

	// Find the course enquiry by id
	@GetMapping("/course/{courseId}")
	public ResponseEntity findByIdCourseEnquiry(@PathVariable("courseId") Integer courseId) {
		CourseEnquiry courseEnquiry = courseEnquiryService.findCourseEnquiryById(courseId);
		if(courseEnquiry == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(courseEnquiry);
	}
	

	// Create the course enquiry
	 @RequestMapping(value = "/course", method = RequestMethod.POST)
	public ResponseEntity saveCourseEnquiry(@RequestBody CourseEnquiry courseEnquiry) {
		courseEnquiryService.saveCourseEnquiry(courseEnquiry);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	 // Update the course enquiry
	 @PutMapping("/course")
	 public ResponseEntity updateCourseEnquiry(@RequestBody CourseEnquiry courseEnquiry) {
		String result = courseEnquiryService.updateCourseEnquiry(courseEnquiry);
		final Map<String, String> body = new HashMap<>();
		body.put("result", result);
		if(result.equalsIgnoreCase("Updated Successfully.")) {
			body.put("resultValue", "1");
		}
		else {
			body.put("resultValue", "0");
		}
		return ResponseEntity.ok(body);
	 }
			
	// Delete the course enquiry
	@DeleteMapping("/course/{courseEnquiryId}")
	public ResponseEntity<Object> deleteCourseEnquiryById(@PathVariable("courseEnquiryId") int id ) {
		CourseEnquiry courseEnquiry = courseEnquiryService.deleteCourseEnquiry(id);
		if(courseEnquiry == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		return ResponseEntity.ok(courseEnquiry);
	}
	
	@GetMapping("/course/filter/status/{courseStatus}")
	public ResponseEntity findByStatusCourseEnquiry(@PathVariable("courseStatus") Integer courseStatus) {
		List<CourseEnquiry> courseEnquiry = courseEnquiryService.findAllCourseEnquiryByStatus(courseStatus);
		if(courseStatus == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(courseEnquiry);
	}
	
	@GetMapping("/course/filter/date/{startDate}/{endDate}")
	public ResponseEntity findByDateCourseEnquiry(@PathVariable("startDate") String startDate,@PathVariable("endDate") String endDate) {
		List<CourseEnquiry> courseEnquiry = courseEnquiryService.findAllCourseEnquiryByDate(startDate, endDate);
		if(startDate == null || endDate == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(courseEnquiry);
	}
	
	@GetMapping("/course/filter/date/{startDate}/{endDate}/{status}")
	public ResponseEntity findByDateAndStatusCourseEnquiry(@PathVariable("startDate") String startDate,@PathVariable("endDate") String endDate,@PathVariable int status) {
		List<CourseEnquiry> courseEnquiry = courseEnquiryService.findAllCourseEnquiryByDateAndStatus(startDate, endDate, status);
		System.out.println(startDate+" "+endDate);
		if(startDate == null || endDate == null )
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(courseEnquiry);
	}
	
	@GetMapping("/course/count")
	public ResponseEntity<Integer> findCourseEnquiryCount() {
		int count = courseEnquiryService.findAllCourseEnquiryCount();
		return ResponseEntity.ok(count);
	}
	
}
