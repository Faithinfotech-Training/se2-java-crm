package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ManageCorEnquiryUpdateDAO;
import com.example.demo.entity.CourseEnquiry;

@Service
public class ManageCorEnquiryUpdateServiceImp implements ManageCorEnquiryUpdateService {

	private ManageCorEnquiryUpdateDAO manageCorEnquiryUpdateDAO;

	@Autowired
	public ManageCorEnquiryUpdateServiceImp(ManageCorEnquiryUpdateDAO manageCorEnquiryUpdateDAO) {
		super();
		this.manageCorEnquiryUpdateDAO = manageCorEnquiryUpdateDAO;
	}

	@Override
	@Transactional
	public List<CourseEnquiry> findAllSortedCourseEnquiry() {
		return manageCorEnquiryUpdateDAO.findAllSortedCourseEnquiry();
	}

	@Override
	@Transactional
	public List<CourseEnquiry> findAllCourseEnquiry(Integer EnquiryStatus) {
		return manageCorEnquiryUpdateDAO.findAllCourseEnquiry(EnquiryStatus);
	}

}
