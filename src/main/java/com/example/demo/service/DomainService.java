package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Domain;

public interface DomainService {
	//get all domain
	public List<Domain> findAllDomain();
	//get damain by id
	public Domain findDomainById(int domainId);
	//insert domain
	public void save(Domain domain);
	//delete domain
	public void deleteDomainById(int domainId);
	
}
