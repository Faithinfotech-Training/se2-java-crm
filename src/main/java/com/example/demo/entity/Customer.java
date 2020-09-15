package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.validation.annotation.Validated;

@Entity
@Table
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer customerId;
	
	@Column(nullable=false, length=20)
	private String customerName;

	@Column(unique=true, nullable=false, length=25)
	private String customerEmailId;
	
	@Column(nullable=false, length=10)
	private String customerPhoneNumber;
	
	@Column(nullable=false)
	private Date customerDOB;
	
	@Column(nullable=false, length=20)
	private String customerQualification;
	
	@Column(nullable=false)
	private Integer percentage;
	
	@Column(nullable=false, length=30)
	private String leadSource;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(Integer customerId, String customerName, String customerEmailId, String customerPhoneNumber,
			Date customerDOB, String customerQualification, Integer percentage, String leadSource) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmailId = customerEmailId;
		this.customerPhoneNumber = customerPhoneNumber;
		this.customerDOB = customerDOB;
		this.customerQualification = customerQualification;
		this.percentage = percentage;
		this.leadSource = leadSource;
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

	public Integer getPercentage() {
		return percentage;
	}

	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
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
				+ ", customerQualification=" + customerQualification + ", percentage=" + percentage + ", leadSource="
				+ leadSource + "]";
	}
	
	

}
