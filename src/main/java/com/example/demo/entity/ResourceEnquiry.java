//Entity Layer of Resource Enquiry
package com.example.demo.entity;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity(name="resource_enquiry")
@Table(name = "Resource_Enquiry")
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

	@OneToOne
	@JoinColumn(name="statusId")
	private ResourceEnquiryStatus status;

	
	@Column
	private Date enquiryDate;

	
	
	
// Default constructor
	public ResourceEnquiry() {
		
		super();
	}

	
	

	
	
	
public ResourceEnquiry(Integer resourceEnquiryId, Customer customer, Resources resources, ResourceEnquiryStatus status,
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

	
	

	
	public ResourceEnquiryStatus getStatus() {
		return status;
	}




	public void setStatus(ResourceEnquiryStatus status) {
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
