package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Domain;

public interface DomainService {

	public List<Domain> findAllDomain();
	
	public Domain findDomainById(int domainId);
	
	public void save(Domain domain);
	
	public void deleteDomainById(int domainId);
	
}
