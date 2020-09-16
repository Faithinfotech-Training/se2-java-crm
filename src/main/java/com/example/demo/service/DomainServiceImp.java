package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.DomainDAO;
import com.example.demo.entity.Domain;

@Service
public class DomainServiceImp implements DomainService {

	DomainDAO domainDAO;
	
	@Autowired
	public DomainServiceImp(DomainDAO domainDAO) {
		this.domainDAO = domainDAO;
	}

	@Override
	@Transactional
	public List<Domain> findAllDomain() {
		return domainDAO.findAllDomain();
	}

	@Override
	@Transactional
	public Domain findDomainById(int domainId) {
		return domainDAO.findDomainById(domainId);
	}

	@Override
	@Transactional
	public void save(Domain domain) {
		domainDAO.save(domain);
	}

	@Override
	@Transactional
	public void deleteDomainById(int domainId) {
		domainDAO.deleteDomainById(domainId);
	}

}
