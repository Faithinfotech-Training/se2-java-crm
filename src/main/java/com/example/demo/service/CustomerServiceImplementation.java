package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.entity.Customer;

@Service
public class CustomerServiceImplementation implements CustomerService {

	private CustomerDAO customerDAO;
	
	
	@Autowired
	public CustomerServiceImplementation(CustomerDAO customerDAO) {
		super();
		this.customerDAO = customerDAO;
	}

	@Override
	public List<Customer> findAllCustomer() {
		return customerDAO.findAllCustomers();
	}

	@Override
	public Customer findByCustomerId(int customerId) {
		return customerDAO.findCustomerById(customerId);
	}

	@Override
	public void saveCustomer(Customer customer) {
		customerDAO.saveCustomer(customer);
	}

	@Override
	public void deleteByCustomerId(int customerId) {
		customerDAO.deleteByCustomerId(customerId);
	}

}
