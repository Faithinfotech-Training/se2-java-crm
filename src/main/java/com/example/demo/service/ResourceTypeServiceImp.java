package com.example.demo.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.ResourceTypeDAO;
import com.example.demo.entity.ResourceType;

@Service
public class ResourceTypeServiceImp implements ResourceTypeService {
	@Autowired
	private ResourceTypeDAO resourceTypeDAO;
	
	
	public ResourceTypeServiceImp(ResourceTypeDAO resourceTypeDAO) {
		super();
		this.resourceTypeDAO = resourceTypeDAO;
	}


	@Override
	@Transactional
	public List<ResourceType> findAll() {
		// TODO Auto-generated method stub
		return resourceTypeDAO.findAllResourceType();
	}


	@Override
	public ResourceType findResourceTypeById(int theId) {
		// TODO Auto-generated method stub
		return resourceTypeDAO.findResourceTypeById(theId);
	}


	@Override
	public void saveResourceType(ResourceType resourceType) {
		// TODO Auto-generated method stub
		resourceTypeDAO.saveResourceType(resourceType);
		
	}
	@Override
	public void deleteResourceTypeById(int id) {
		resourceTypeDAO.deleteResourceTypeById(id);
	}

}
