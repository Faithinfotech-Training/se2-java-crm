<<<<<<< HEAD
package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ResourceEnquiry;

public interface ResourceEnquiryService {

	
	public List<ResourceEnquiry> findAllResourceEnquiry();
	
	
	public ResourceEnquiry findByResourceEnquiryId(int theId);
	
	public void saveResourceEnquiry(ResourceEnquiry resourceEnquiry);
	
	public void updateResourceEnquiry(int resourceEnquiryId, ResourceEnquiry resourceEnquiry);
	
	public void deleteByResourceEnquiryId(int resourceEnquiryId);
	
	public List<ResourceEnquiry> findAllResourceEnquiryByStatus(int status);
	
	public List<ResourceEnquiry> findAllResourceEnquiryByResourceType(int resourceType);
}
=======
package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ResourceEnquiry;

public interface ResourceEnquiryService {

	
	public List<ResourceEnquiry> findAllResourceEnquiry();
	
	
	public ResourceEnquiry findByResourceEnquiryId(int theId);
	
	public void saveResourceEnquiry(ResourceEnquiry resourceEnquiry);
	
	public String updateResourceEnquiry(ResourceEnquiry resourceEnquiry);
	
	public void deleteByResourceEnquiryId(int resourceEnquiryId);
	
	public List<ResourceEnquiry> findAllResourceEnquiryByStatus(int status);
	
	public List<ResourceEnquiry> findAllResourceEnquiryByResourceType(int resourceType);
	
	
}
>>>>>>> 5f19ed8f8d38ffa3256101883bb0c8f6c5603409
