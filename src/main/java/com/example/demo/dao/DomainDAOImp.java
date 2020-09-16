package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Domain;

@Repository
public class DomainDAOImp implements DomainDAO {

	private EntityManager entityManager;

	@Autowired
	public DomainDAOImp(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Domain> findAllDomain() {
		// create query for find all domain
		Query query = entityManager.createQuery("from Domain");
		// save result to list of domain
		List<Domain> domain = query.getResultList();
		// return domain
		return domain;
	}

	@Override
	public Domain findDomainById(int domainId) {
		// find domain by id
		Domain domain = entityManager.find(Domain.class, domainId);
		// return the result
		return domain;
	}

	@Override
	public void save(Domain domain) {
		// insert new domain
		Domain tempDomain = entityManager.merge(domain);
		domain.setDomainId(tempDomain.getDomainId());

	}

	@Override
	public void deleteDomainById(int domainId) {
		// delete query for domain table
		Query query = entityManager.createNativeQuery("DELETE FROM domain WHERE DOMAIN_ID = " + domainId);
		// execute delete query
		query.executeUpdate();
	}

}
