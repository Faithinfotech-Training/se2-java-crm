package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Resources;
import com.example.demo.entity.Status;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;




@Repository
public class StatusDAOImp implements StatusDAO {

	 private EntityManager entityManager;
	    
	    @Autowired
	    public StatusDAOImp(EntityManager entityManager) {
	        this.entityManager = entityManager;
	    }
	    
	@Override
	public List<Status> findAllStatus() {
		// TODO Auto-generated method stub
	    Query myQuery = entityManager.createQuery("from Status");
        List<Status> status = myQuery.getResultList();
        return status;
	}

	@Override
	public Status findStatusById(int theId) {
		// TODO Auto-generated method stub
		  Status status = (Status) entityManager.find(Status.class, theId);
	        return status;
	}
	
// Save in Status in database
	@Override
	public void saveStatus(Status status) {
		// TODO Auto-generated method stub
		   // save or update the Resource
        Status dbStatus = entityManager.merge(status);
        // update with id from db ... so we can get generated id for save/insert
        status.setStatusId(dbStatus.getStatusId());
		
	}
	
//	Delete Status by given id
	@Override
	public Status deleteStatusById(int id) {
		// TODO Auto-generated method stub
		 Status status = (Status) entityManager.find(Status.class, id);
	        // if status exists then remove else return null
	        if (entityManager.contains(status)) {
	            entityManager.remove(status);
	        } else {
	            return null;    
	        }
	        return status;
		
	}

	

}
