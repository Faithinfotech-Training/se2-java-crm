package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Customer;
import com.example.demo.entity.ResourceEnquiry;

@Repository
public class CustomerDAOImplementation implements CustomerDAO {

	private EntityManager entityManager;

	@Autowired
	public CustomerDAOImplementation(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public List<Customer> findAllCustomers() {
		 List<Customer> customers= entityManager.createQuery("from Customer").getResultList();
	        return customers;
	}

	@Override
	@Transactional
	public Customer findCustomerById(int customerId) {
		 Customer customer = entityManager.find(Customer.class, customerId);
		return customer;
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {

		Customer dbCustomer = entityManager.merge(customer);
		customer.setCustomerId(dbCustomer.getCustomerId());

	}

	@Override
	@Transactional
	public Customer deleteByCustomerId(int customerId) {
		
		Customer customer = (Customer) entityManager.find(Customer.class,
				customerId);

		if (entityManager.contains(customer)) {
			entityManager.remove(customer);
		} else {
			return null;
		}
		return customer;

	}

}
