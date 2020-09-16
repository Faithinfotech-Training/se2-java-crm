package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Resources;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ResourcesDAOImp implements ResourcesDAO {
	
	
	private EntityManager entityManager;
    
    @Autowired
    public ResourcesDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
	public List<Resources> findAllResources() {
		// TODO Auto-generated method stub
	     // create a query 
        Query myQuery = entityManager.createQuery("from Resources");
        List<Resources> resources = myQuery.getResultList();
        return resources;
	}

	@Override
	public Resources findResourcesById(int theId) {
		// TODO Auto-generated method stub
		  //find resource by Id
        Resources resource = (Resources) entityManager.find(Resources.class, theId);
        return resource;
	}

	@Override
	@Transactional
	public void saveResources(Resources resources) {
		// TODO Auto-generated method stu
        
     // save or update the Resource
        Resources dbResources = entityManager.merge(resources);
        // update with id from db ... so we can get generated id for save/insert
        resources.setResourceId(dbResources.getResourceId());
	}

	@Override
	@Transactional
	public Resources deleteResourcesById(int id) {
		// TODO Auto-generated method stub
		Resources resource = (Resources) entityManager.find(Resources.class, id);
        // if resource exists then remove else return null
        if (entityManager.contains(resource)) {
            entityManager.remove(resource);
        } else {
            return null;    
        }
        return resource;
	}
	
	
	

}
