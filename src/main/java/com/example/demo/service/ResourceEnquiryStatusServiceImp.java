package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ResourceEnquiryStatusDAO;
import com.example.demo.entity.ResourceEnquiryStatus;

@Service
public class ResourceEnquiryStatusServiceImp implements ResourceEnquiryStatusService {

	private ResourceEnquiryStatusDAO resourceEnquiryStatusDAO;
	@Autowired
	public ResourceEnquiryStatusServiceImp(ResourceEnquiryStatusDAO resourceEnquiryStatusDAO) {
		super();
		this.resourceEnquiryStatusDAO = resourceEnquiryStatusDAO;
	}

	
	@Override
	@Transactional
	public void saveResourceEnquiryStatus(ResourceEnquiryStatus enquiryStatus) {
			resourceEnquiryStatusDAO.saveEnquiryStatus(enquiryStatus);
	}

	@Override
	@Transactional
	public List<ResourceEnquiryStatus> findAllResourceEnquiryStatus() {
		return	resourceEnquiryStatusDAO.findAllEnquiryStatus();
		
	}

	@Override
	@Transactional
	public ResourceEnquiryStatus findResourceEnquiryStatusById(Integer id) {
		// TODO Auto-generated method stub
		return resourceEnquiryStatusDAO.findEnquiryStatusById(id);
	}

	@Override
	@Transactional
	public boolean updateResourceEnquiryStatus(ResourceEnquiryStatus enquiryStatus) {
		
		return resourceEnquiryStatusDAO.updateEnquiryStatus(enquiryStatus);
	}

	@Override
	@Transactional
	public ResourceEnquiryStatus deleteEnquiryStatus(Integer id) {
		
		return resourceEnquiryStatusDAO.deleteEnquiryStatus(id);
	}

}
