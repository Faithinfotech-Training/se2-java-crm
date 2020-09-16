package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Customer;

@Repository
public interface CustomerDAO {

	
	public List<Customer> findAllCustomers();

	public Customer findCustomerById(int customerId);

	public void saveCustomer(Customer customer);
	
	public Customer deleteByCustomerId(int customerId);

}
