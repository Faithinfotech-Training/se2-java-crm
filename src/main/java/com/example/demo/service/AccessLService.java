package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.AccessL;

public interface AccessLService {

	public List<AccessL> findAllAccess();
	
	public AccessL findAccessById(int accessId);
	
	public void save(AccessL accessL);
	
	public void deleteAccessById(int accessId);
	
}
