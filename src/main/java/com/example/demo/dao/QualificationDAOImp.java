package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Qualification;

@Repository
public class QualificationDAOImp implements QualificationDAO {

	private EntityManager entityManager;

	@Autowired
	public QualificationDAOImp(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Qualification> findAllQualification() {
		// create query for find all qualification
		Query query = entityManager.createQuery("from Qualification");
		// save result to list of qualification
		List<Qualification> qualification = query.getResultList();
		// return qualification
		return qualification;
	}

	@Override
	public Qualification findQualificationById(int qualificationId) {
		// find qualification by id
		Qualification qualification = entityManager.find(Qualification.class, qualificationId);
		// return the result
		return qualification;
	}

	@Override
	public void save(Qualification qualification) {
		// insert new qualification
		Qualification tempQualification = entityManager.merge(qualification);
		qualification.setQualificationId(tempQualification.getQualificationId());

	}

	@Override
	public void deleteQualificationById(int qualificationId) {
		// delete query for qualification table
		Query query = entityManager.createNativeQuery("DELETE FROM qualification WHERE QUALIFICATION_ID = " + qualificationId);
		// execute delete query
		query.executeUpdate();
	}

}
