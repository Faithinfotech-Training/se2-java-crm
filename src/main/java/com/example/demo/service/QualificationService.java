package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Qualification;

public interface QualificationService {

	public List<Qualification> findAllQualification();
	
	public Qualification findQualificationById(int qualificationId);
	
	public void save(Qualification qualification);
	
	public void deleteQualificationById(int qualificationId);
	
}
