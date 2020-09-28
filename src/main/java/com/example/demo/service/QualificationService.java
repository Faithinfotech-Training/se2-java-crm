package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Qualification;

public interface QualificationService {
	//get all qualification
	public List<Qualification> findAllQualification();
	//get qualification by id		
	public Qualification findQualificationById(int qualificationId);
	//save into qualification
	public void save(Qualification qualification);
	//delete from qualification
	public void deleteQualificationById(int qualificationId);
	
}
