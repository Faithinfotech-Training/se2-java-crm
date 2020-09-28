package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class CustomerController {

	private CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

//This Method gets all the customers	
	@GetMapping(value = "/customer")
	public List<Customer> findAllCustomers() {

		List<Customer> customers = customerService.findAllCustomer();
		return customers;
	}

//This method gets a specific Customer according to the given customer ID
	@GetMapping(value = "/customer/{customerid}")
	public Customer findByCustomerId(@PathVariable Integer customerid) {

		return customerService.findByCustomerId(customerid);
	}

//This Method Posts a new Customer from the request body.
	@PostMapping(value = "/customer")
	public Customer saveCustomer(@RequestBody Customer customer) {

		customer.setCustomerId(0);
		customerService.saveCustomer(customer);
		return customer;

	}

//This method updates the exisiting customer
	@PutMapping(value = "/customer")
	public Customer updateResourceEnquiryStatus(@RequestBody Customer customer) {

		customerService.saveCustomer(customer);
		return customer;
	}

//This method deletes the Customer for a given customer Id 
	@DeleteMapping(value = "/customer/{customerid}")
	public String deleteByCustomerId(@PathVariable int customerid) {

		Customer tempCustomer = customerService.findByCustomerId(customerid);
		// throw exception if null
		if (tempCustomer == null) {
			throw new RuntimeException("Customer id not found - " + customerid);
		}
		customerService.deleteByCustomerId(customerid);
		return "Deleted customer id - " + customerid;
	}

}
