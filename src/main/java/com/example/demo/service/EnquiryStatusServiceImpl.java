package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EnquiryStatusDAO;
import com.example.demo.entity.EnquiryStatus;

@Service
public class EnquiryStatusServiceImpl implements EnquiryStatusService {

	private EnquiryStatusDAO enquiryStatusDAO;
	
	@Autowired
	public EnquiryStatusServiceImpl(EnquiryStatusDAO enquiryStatusDAO) {
		super();
		this.enquiryStatusDAO = enquiryStatusDAO;
	}

	@Override
	@Transactional
	public void saveEnquiryStatus(EnquiryStatus enquiryStatus) {
		// save the enquiry status
		enquiryStatusDAO.saveEnquiryStatus(enquiryStatus);
	}

	@Override
	@Transactional
	public List<EnquiryStatus> findAllEnquiryStatus() {
		// return all the enquiry statuses in a list
		return enquiryStatusDAO.findAllEnquiryStatus();
	}

	@Override
	@Transactional
	public EnquiryStatus findEnquiryStatusById(Integer id) {
		// find enquiry status by id
		return enquiryStatusDAO.findEnquiryStatusById(id);
	}

	@Override
	@Transactional
	public boolean updateEnquiryStatus(EnquiryStatus enquiryStatus) {
		// update enquiry status
		return enquiryStatusDAO.updateEnquiryStatus(enquiryStatus);
	}

	@Override
	@Transactional
	public EnquiryStatus deleteEnquiryStatus(Integer id) {
		// delete enquiry status by id
		return enquiryStatusDAO.deleteEnquiryStatus(id);
	}

}
