package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Qualification;

public interface QualificationDAO {
	//view qualification
	public List<Qualification> findAllQualification();
	//view qualification by id
	public Qualification findQualificationById(int qualificationId);
	//create qualification
	public void save(Qualification department);
	//delete qualification
	public void deleteQualificationById(int qualificationId);

}
