package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.AccessLDAO;
import com.example.demo.entity.AccessL;

@Service
public class AccessLServiceImp implements AccessLService {

	AccessLDAO accessLDAO;
	
	@Autowired
	public AccessLServiceImp(AccessLDAO accessLDAO) {
		this.accessLDAO = accessLDAO;
	}

	@Override
	@Transactional
	public List<AccessL> findAllAccess() {
		return accessLDAO.findAllAccess();
	}

	@Override
	@Transactional
	public AccessL findAccessById(int accessId) {
		return accessLDAO.findAccessById(accessId);
	}

	@Override
	@Transactional
	public void save(AccessL accessL) {
		accessLDAO.save(accessL);
	}

	@Override
	@Transactional
	public void deleteAccessById(int accessId) {
		accessLDAO.deleteAccessById(accessId);
	}

}
