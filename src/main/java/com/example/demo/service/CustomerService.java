package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Customer;

public interface CustomerService {


	public List<Customer> findAllCustomer();
	
	
	public Customer findByCustomerId(int theId);
	
	public void saveCustomer(Customer customer);
	
	public void deleteByCustomerId(int customerId);
}
