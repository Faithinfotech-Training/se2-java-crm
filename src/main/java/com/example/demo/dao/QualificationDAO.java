package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Qualification;

public interface QualificationDAO {
	
	public List<Qualification> findAllQualification();
	
	public Qualification findQualificationById(int qualificationId);
	
	public void save(Qualification department);
	
	public void deleteQualificationById(int qualificationId);

}
