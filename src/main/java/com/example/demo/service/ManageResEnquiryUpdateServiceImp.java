package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.dao.ManageResEnquiryUpdateDAO;
import com.example.demo.entity.ResourceEnquiry;

@Service
public class ManageResEnquiryUpdateServiceImp implements ManageResEnquiryUpdateService {

	// Create a Manage Resource Enquiry Update Status DAO Instance
	private ManageResEnquiryUpdateDAO manageResEnquiryUpdateDAO; 
	
	public ManageResEnquiryUpdateServiceImp(ManageResEnquiryUpdateDAO manageResEnquiryUpdateDAO) {
		super();
		this.manageResEnquiryUpdateDAO = manageResEnquiryUpdateDAO;
	}

	@Override
	@Transactional
	public List<ResourceEnquiry> findAllSortedResourceEnquiry() {
		// return a list of sorted Resource enquiries
		return manageResEnquiryUpdateDAO.findAllSortedResourceEnquiry();
	}

	@Override
	@Transactional
	public List<ResourceEnquiry> findAllResourceEnquiry(String resourceEnquiryStatus) {
		// return list of resource enquiries with the type of resource enquiry status
		return manageResEnquiryUpdateDAO.findAllResourceEnquiry(resourceEnquiryStatus);
	}

}
