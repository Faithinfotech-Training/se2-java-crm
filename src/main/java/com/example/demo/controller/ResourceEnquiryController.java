//Controller Layer for Resource Enquiry
package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ResourceEnquiry;
import com.example.demo.service.ResourceEnquiryServiceImplementation;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/enquiry")
public class ResourceEnquiryController {

	@Autowired
	ResourceEnquiryServiceImplementation resourceEnquiryServiceImplementation;

//This Method gets all the Resource Enquiries.	
	@GetMapping(value = "/resource")
	public List<ResourceEnquiry> findAllResourceEnquiries() {

		List<ResourceEnquiry> enquiries = resourceEnquiryServiceImplementation.findAllResourceEnquiry();
		return enquiries;
	}

//This method gets a specific Resource enquire according to the given resource Enquiry ID
	@GetMapping(value = "/resource/{resourceEnquiryId}")
	public ResourceEnquiry findByResourceEnquiryId(@PathVariable Integer resourceEnquiryId) {

		ResourceEnquiry resourceEnquiry = resourceEnquiryServiceImplementation
				.findByResourceEnquiryId(resourceEnquiryId);
		return resourceEnquiry;
	}

//This Method Posts a new Request Enquiry from the request body.
	@PostMapping(value = "/resource")
	public ResourceEnquiry saveResourceEnquiry(@RequestBody ResourceEnquiry resourceEnquiry) {

		resourceEnquiryServiceImplementation.saveResourceEnquiry(resourceEnquiry);
		return resourceEnquiry;

	}

//This method updates the exisiting Resource Enquiry by using the Resource Enquiry ID and replaces the data with the data given in request body
	@PutMapping(value = "/resource")
		public ResponseEntity updateResourceEnquiryStatus(@RequestBody ResourceEnquiry resourceEnquiry)
		{
			String result = resourceEnquiryServiceImplementation.updateResourceEnquiry(resourceEnquiry);
			final Map<String,String> body = new HashMap<>();
			body.put("result", result);
			if(result.equalsIgnoreCase("Updated Successfully."))
			{body.put("resultValue", "1");
			}
			else
			{
				body.put("resultValue","0");
			}
			return ResponseEntity.ok(body);
		}

//This method deletes the Resource enquiry for a given Resource 
	@DeleteMapping(value = "/resource/{enquiryid}")
	public void deleteByResourceEnquiryId(@PathVariable Integer enquiryid) {

		resourceEnquiryServiceImplementation.deleteByResourceEnquiryId(enquiryid);

	}

	/**
	 * Manager view controllers
	 */

	/**
	 * Filter by status 1. Active 2. Inactive
	 **/
	@GetMapping(value = "/resource/filter/status/{statusId}")
	public List<ResourceEnquiry> findAllResourceEnquiriesByStatus(@PathVariable("statusId") Integer statusId) {

		List<ResourceEnquiry> enquiries = resourceEnquiryServiceImplementation.findAllResourceEnquiryByStatus(statusId);
		return enquiries;
	}

	@GetMapping(value = "/resource/filter/resourcetype/{resourceType}")
	public List<ResourceEnquiry> findAllResourceEnquiriesByResourceType(
			@PathVariable("resourceType") Integer resourceType) {

		List<ResourceEnquiry> enquiries = resourceEnquiryServiceImplementation
				.findAllResourceEnquiryByResourceType(resourceType);
		return enquiries;
	}
	
	@GetMapping("/resource/filter/date/{startDate}/{endDate}")
	public ResponseEntity findByDateResourceEnquiry(@PathVariable("startDate") String startDate,@PathVariable("endDate") String endDate) {
		List<ResourceEnquiry> resourceEnquiry = resourceEnquiryServiceImplementation.findAllResourceEnquiryByDate(startDate, endDate);
		if(startDate == null || endDate == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(resourceEnquiry);
	}
	
	@GetMapping("/resource/filter/date/{startDate}/{endDate}/{status}")
	public ResponseEntity findByDateAndStatusResourceEnquiry(@PathVariable("startDate") String startDate,@PathVariable("endDate") String endDate,@PathVariable int status) {
		List<ResourceEnquiry> resourceEnquiry = resourceEnquiryServiceImplementation.findAllResourceEnquiryByDateAndStatus(startDate, endDate, status);
		if(startDate == null || endDate == null )
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(resourceEnquiry);
	}
	
	@GetMapping("/resource/count")
	public ResponseEntity<Integer> findResourceEnquiryCount() {
		int count = resourceEnquiryServiceImplementation.findAllResourceEnquiryCount();
		return ResponseEntity.ok(count);
	}
}
