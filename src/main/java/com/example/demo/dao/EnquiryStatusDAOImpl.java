package com.example.demo.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.EnquiryStatus;


@Repository
public class EnquiryStatusDAOImpl implements EnquiryStatusDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	public EnquiryStatusDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public void saveEnquiryStatus(EnquiryStatus enquiryStatus) {
		// Save the enquiry status
		enquiryStatus.setStatusId(0);
		entityManager.merge(enquiryStatus);
	}

	@Override
	public List<EnquiryStatus> findAllEnquiryStatus() {
		
		// create a query
		Query myQuery = entityManager.createQuery("from enquirystatus");
		// extract the results
		List<EnquiryStatus> enquiryStatuses = myQuery.getResultList();	
		// return the course enquiries list
		return enquiryStatuses;
	
	}

	@Override
	public EnquiryStatus findEnquiryStatusById(Integer id) {
		// find the enquiry status  by id
		EnquiryStatus enquiryStatus = entityManager.find(EnquiryStatus.class, id);
		return enquiryStatus;
	}

	@Override
	public boolean updateEnquiryStatus(EnquiryStatus enquiryStatus) {
		// TODO Auto-generated method stub
		entityManager.merge(enquiryStatus);
		return true;
	}

	@Override
	public EnquiryStatus deleteEnquiryStatus(Integer id) {
		//Find CourseEnquiry
		EnquiryStatus enquiryStatus = (EnquiryStatus) entityManager.find(EnquiryStatus.class, id);
		// If CourseEnquiry is present remove else return null
		if (entityManager.contains(enquiryStatus)) {
			entityManager.remove(enquiryStatus);
		} else {
			return null;
		}
		return enquiryStatus;
	}

}
