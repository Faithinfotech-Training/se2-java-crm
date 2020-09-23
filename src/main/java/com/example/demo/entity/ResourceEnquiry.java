<<<<<<< HEAD
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
=======
//Entity Layer of Resource Enquiry
package com.example.demo.entity;

import java.sql.Date;

import javax.annotation.Resource;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity(name="resource_enquiry")
@Table(name = "Resource_Enquiry")
public class ResourceEnquiry {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer resourceEnquiryId;

	
	@ManyToOne(cascade=CascadeType.ALL, targetEntity=Customer.class)
	@JoinColumn(name = "customerId")
	private Customer customerId;

	
	@ManyToOne(cascade=CascadeType.ALL, targetEntity=Resources.class)
	@JoinColumn(name = "resourceId")
	private Resources resourcesId;

	@ManyToOne
	@JoinColumn(name="status_id")
	private ResourceEnquiryStatus status;

	
	@Column
	private Date enquiryDate;

	
	
	
// Default constructor
	public ResourceEnquiry() {
		
		super();
	}

	


public ResourceEnquiry(Integer resourceEnquiryId, Customer customerId, Resources resourcesId,
		ResourceEnquiryStatus status, Date enquiryDate) {
	super();
	this.resourceEnquiryId = resourceEnquiryId;
	this.customerId = customerId;
	this.resourcesId = resourcesId;
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

	

	

	
	public Customer getCustomerId() {
		return customerId;
	}








	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}








	public Resources getResourcesId() {
		return resourcesId;
	}








	public void setResourcesId(Resources resourcesId) {
		this.resourcesId = resourcesId;
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
		return "ResourceEnquiry [resourceEnquiryId=" + resourceEnquiryId + ", customerId=" + customerId
				+ ", resourcesId=" + resourcesId + ", status=" + status + ", enquiryDate=" + enquiryDate + "]";
	}

	
	



}
>>>>>>> 5f19ed8f8d38ffa3256101883bb0c8f6c5603409
