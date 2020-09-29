package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Clickenquiry;
import com.example.demo.entity.Course;

@Repository
public class ClickDAOImpl implements ClickDAO {


	private EntityManager entityManager;

	@Autowired
	public ClickDAOImpl(EntityManager entityManager) {
		
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Clickenquiry> findAllByClickDate() {
		
		List<Clickenquiry> list=new ArrayList<Clickenquiry>();
		Query myQuery = entityManager.createQuery("from clickenquiry");
		list=myQuery.getResultList();
		return list;
	}

	 @Transactional
	@Override
	public void save(Clickenquiry clickenquiry) {
	entityManager.persist(clickenquiry);
		System.out.println("Saved");
		
	}

}
