package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.ResourceType;
import com.example.demo.entity.Resources;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ResourceTypeDAOImp implements ResourceTypeDAO {

	
	 private EntityManager entityManager;
	 
	 @Autowired
	    public ResourceTypeDAOImp(EntityManager entityManager) {
	        this.entityManager = entityManager;
	    }

	@Override
	public List<ResourceType> findAllResourceType() {
		// TODO Auto-generated method stub
		Query myQuery = entityManager.createQuery("from ResourceType");
        List<ResourceType> resourceTypes = myQuery.getResultList();
        return resourceTypes;
	}

	@Override
	public ResourceType findResourceTypeById(int theId) {
		// TODO Auto-generated method stub
		  ResourceType resourceType = (ResourceType) entityManager.find(ResourceType.class, theId);
	        return resourceType;
	}

	@Override
	@Transactional
	public void saveResourceType(ResourceType resourceType) {
		// TODO Auto-generated method stub
		  //create a save query
        entityManager.persist(resourceType);
		
	}

	@Override
	@Transactional
	public ResourceType deleteResourceTypeById(int id) {
		// TODO Auto-generated method stub
		
		  ResourceType resourceType = (ResourceType) entityManager.find(ResourceType.class, id);
	        // if resourceType exists then remove else return null
	        if (entityManager.contains(resourceType)) {
	            entityManager.remove(resourceType);
	        } else {
	            return null;    
	        }
	        return resourceType;
		
	}
	    




}
