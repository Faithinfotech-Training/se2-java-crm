package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	
	// Customer Id - primary key
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer customerId;
	
	// Customer Full Name
	@Column(nullable=false, length=20)
	private String customerName;

	// Customer Email Id
	@Column(unique=true, nullable=false, length=20)
	private String customerEmailId;
	
	// Customer Phone number
	@Column(nullable=false, length=10)
	private String customerPhoneNumber;
	
	// Date of Birth(DOB) of customer
	@Column(nullable=false)
	private Date customerDOB;
	
	//Customer qualification
	@Column(nullable=false, length=20)
	private String customerQualification;
	
	// Customer Percentage obtained in the qualification
	@Column(nullable=false)
	private Integer customerPercentage;
	
	// lead Source/ reference
	@Column(nullable=false, length=20)
	private String leadSource;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(Integer customerId, String customerName, String customerEmailId, String customerPhoneNumber,
			Date customerDOB, String customerQualification, Integer customerPercentage, String leadSource) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmailId = customerEmailId;
		this.customerPhoneNumber = customerPhoneNumber;
		this.customerDOB = customerDOB;
		this.customerQualification = customerQualification;
		this.customerPercentage = customerPercentage;
		this.leadSource = leadSource;
	}


	public Integer getCustomerPercentage() {
		return customerPercentage;
	}

	public void setCustomerPercentage(Integer customerPercentage) {
		this.customerPercentage = customerPercentage;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmailId() {
		return customerEmailId;
	}

	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}

	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	public Date getCustomerDOB() {
		return customerDOB;
	}

	public void setCustomerDOB(Date customerDOB) {
		this.customerDOB = customerDOB;
	}

	public String getCustomerQualification() {
		return customerQualification;
	}

	public void setCustomerQualification(String customerQualification) {
		this.customerQualification = customerQualification;
	}


	public String getLeadSource() {
		return leadSource;
	}

	public void setLeadSource(String leadSource) {
		this.leadSource = leadSource;
	}
	

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerEmailId="
				+ customerEmailId + ", customerPhoneNumber=" + customerPhoneNumber + ", customerDOB=" + customerDOB
				+ ", customerQualification=" + customerQualification + ", customerPercentage=" + customerPercentage
				+ ", leadSource=" + leadSource + "]";
	}	

}
