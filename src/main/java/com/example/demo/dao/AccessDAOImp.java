package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Access;

@Repository
public class AccessDAOImp implements AccessDAO {

	EntityManager entityManager;

	@Autowired
	public AccessDAOImp(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Access> findAllAccess() {
		// create query for find all access
		Query query = entityManager.createQuery("from Access");
		// save result to list of access
		List<Access> access = query.getResultList();
		// return access
		return access;
	}

}
