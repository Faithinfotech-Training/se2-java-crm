package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Domain;

public interface DomainDAO {
	//view all domains
	public List<Domain> findAllDomain();
	//view domain by id
	public Domain findDomainById(int domainId);
	//save domain
	public void save(Domain domain);
	//delete domain
	public void deleteDomainById(int domainId);

}
