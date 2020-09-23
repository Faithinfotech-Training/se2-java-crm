//Entity Layer of Resource Enquiry
package com.example.demo.entity;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "ResourceEnquiry")
public class ResourceEnquiry {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private Integer resourceEnquiryId;

	
	@OneToOne
	@JoinColumn(name = "customerId")
	private Customer customer;

	
	@OneToOne
	@JoinColumn(name = "resourceId")
	private Resources resources;

	
	@Column(nullable = false, length = 50)
	private String status;

	
	@Column
	private Date enquiryDate;

	
	
	
// Default constructor
	public ResourceEnquiry() {
		
		super();
	}

	
	
	
// Parameterised Constructor
	public ResourceEnquiry(Integer resourceEnquiryId, Customer customer, Resources resources, String status,
			Date enquiryDate) {
	
		super();
		this.resourceEnquiryId = resourceEnquiryId;
		this.customer = customer;
		this.resources = resources;
		this.status = status;
		this.enquiryDate = enquiryDate;
	}

	
	
	
// Getters and Setters
	public Integer getResourceEnquiryId() {
	
		return resourceEnquiryId;
	}

	
	public void setResourceEnquiryId(Integer resourceEnquiryId) {
		this.resourceEnquiryId = resourceEnquiryId;
	}

	
	public Customer getCustomer() {
		return customer;
	}

	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	public Resources getResource() {
		return resources;
	}

	
	public void setResource(Resources resource) {
		this.resources = resource;
	}

	
	public String getStatus() {
		return status;
	}

	
	public void setStatus(String status) {
		this.status = status;
	}

	
	public Date getEnquiryDate() {
		return enquiryDate;
	}

	
	public void setEnquiryDate(Date enquiryDate) {
		this.enquiryDate = enquiryDate;
	}

	
	
//To String Method
	@Override
	public String toString() {
		return "ResourceEnquiry [resourceEnquiryId=" + resourceEnquiryId + ", customer=" + customer + ", resource="
				+ resources + ", status=" + status + ", enquiryDate=" + enquiryDate + "]";
	}

}
