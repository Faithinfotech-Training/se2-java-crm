package com.example.demo.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.StatusDAO;
import com.example.demo.entity.Status;

@Service
public class StatusServiceImp implements StatusService {
	@Autowired
	private StatusDAO statusDAO;
	
	
	public StatusServiceImp(StatusDAO statusDAO) {
		super();
		this.statusDAO = statusDAO;
	}


	@Override
	@Transactional
	public List<Status> findAll() {
		// TODO Auto-generated method stub
		return statusDAO.findAllStatus();
	}


	@Override
	public Status findStatusById(int theId) {
		// TODO Auto-generated method stub
		return statusDAO.findStatusById(theId);
	}


	@Override
	public void saveStatus(Status status) {
		// TODO Auto-generated method stub
		statusDAO.saveStatus(status);
		
	}
	@Override
	public void deleteStatusById(int id) {
		statusDAO.deleteStatusById(id);
	}

}
