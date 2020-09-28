package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.DomainDAO;
import com.example.demo.entity.Domain;

@Service
public class DomainServiceImp implements DomainService {
	//dao instance created
	DomainDAO domainDAO;
	
	@Autowired
	public DomainServiceImp(DomainDAO domainDAO) {
		this.domainDAO = domainDAO;
	}

	@Override
	@Transactional
	public List<Domain> findAllDomain() {
		//get all domain
		return domainDAO.findAllDomain();
	}

	@Override
	@Transactional
	public Domain findDomainById(int domainId) {
		//get domain by id
		return domainDAO.findDomainById(domainId);
	}

	@Override
	@Transactional
	public void save(Domain domain) {
		//insert into domain
		domainDAO.save(domain);
	}

	@Override
	@Transactional
	public void deleteDomainById(int domainId) {
		//delete domain
		domainDAO.deleteDomainById(domainId);
	}

}
