package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.AccessL;

@Repository
public class AccessLDAOImp implements AccessLDAO {

	EntityManager entityManager;

	@Autowired
	public AccessLDAOImp(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<AccessL> findAllAccess() {
		// create query for find all access
		Query query = entityManager.createQuery("from AccessL");
		// save result to list of access
		List<AccessL> accessL = query.getResultList();
		// return access
		return accessL;
	}

	@Override
	public AccessL findAccessById(int accessId) {
		// find access by id
		AccessL accessL = entityManager.find(AccessL.class, accessId);
		// return the result
		return accessL;
	}

	@Override
	public void save(AccessL accessL) {
		// insert new access
		AccessL tempAccess = entityManager.merge(accessL);
		accessL.setAccessId(tempAccess.getAccessId());

	}

	@Override
	public void deleteAccessById(int accessId) {
		// delete query for access table
		Query query = entityManager.createNativeQuery("DELETE FROM COURSE WHERE COURSE_ID = " + accessId);
		// execute delete query
		query.executeUpdate();
	}

}
