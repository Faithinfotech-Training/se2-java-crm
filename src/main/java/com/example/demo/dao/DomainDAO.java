package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Domain;

public interface DomainDAO {
	
	public List<Domain> findAllDomain();
	
	public Domain findDomainById(int domainId);
	
	public void save(Domain domain);
	
	public void deleteDomainById(int domainId);

}
