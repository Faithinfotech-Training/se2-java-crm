package com.example.demo.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.ResourcesDAO;
import com.example.demo.entity.Resources;

@Service
public class ResourcesServiceImp implements ResourcesService {
	
	private ResourcesDAO resourcesDAO;
	
	@Autowired
	public ResourcesServiceImp(@Qualifier("resourcesDAOImp") ResourcesDAO resourcesDAO) {
		super();
		this.resourcesDAO = resourcesDAO;
	}


	@Override
	@Transactional
	public List<Resources> findAll() {
		// TODO Auto-generated method stub
		return resourcesDAO.findAllResources();
	}


	@Override
	public Resources findResourcesById(int theId) {
		// TODO Auto-generated method stub
		return resourcesDAO.findResourcesById(theId);
	}


	@Override
	public void saveResources(Resources resources) {
		// TODO Auto-generated method stub
		resourcesDAO.saveResources(resources);
		
	}
	@Override
	public void deleteResourcesById(int id) {
		resourcesDAO.deleteResourcesById(id);
	}

}
