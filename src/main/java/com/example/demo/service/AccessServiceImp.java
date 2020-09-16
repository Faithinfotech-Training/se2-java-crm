package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Access;
import com.example.demo.dao.AccessDAO;

@Service
public class AccessServiceImp implements AccessService {
	// Access DAO Instance
	private AccessDAO accessDAO;
	
	@Autowired
	public AccessServiceImp(AccessDAO accessDAO) {
		this.accessDAO = accessDAO;
	}

	@Override
	@Transactional
	public List<Access> findAllAccess() {
		//get all access
		return accessDAO.findAllAccess();
	}
	
}
