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

	
	@ManyToOne(cascade=CascadeType.MERGE, targetEntity=Customer.class)
	@JoinColumn(name = "customerId")
	private Customer customerId;

	
	@ManyToOne(cascade=CascadeType.MERGE, targetEntity=Resources.class)
	@JoinColumn(name = "resourceId")
	private Resources resourcesId;

	@ManyToOne(cascade=CascadeType.MERGE, targetEntity=ResourceEnquiryStatus.class)
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
