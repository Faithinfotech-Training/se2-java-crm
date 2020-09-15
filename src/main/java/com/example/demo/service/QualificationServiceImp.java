package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.QualificationDAO;
import com.example.demo.entity.Qualification;

@Service
public class QualificationServiceImp implements QualificationService {

	QualificationDAO qualificationDAO;
	
	@Autowired
	public QualificationServiceImp(QualificationDAO qualificationDAO) {
		this.qualificationDAO = qualificationDAO;
	}

	@Override
	@Transactional
	public List<Qualification> findAllQualification() {
		return qualificationDAO.findAllQualification();
	}

	@Override
	@Transactional
	public Qualification findQualificationById(int qualificationId) {
		return qualificationDAO.findQualificationById(qualificationId);
	}

	@Override
	@Transactional
	public void save(Qualification qualification) {
		qualificationDAO.save(qualification);
	}

	@Override
	@Transactional
	public void deleteQualificationById(int qualificationId) {
		qualificationDAO.deleteQualificationById(qualificationId);
	}

}
