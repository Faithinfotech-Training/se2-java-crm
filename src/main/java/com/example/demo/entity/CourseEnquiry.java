package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
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
@Table(name="courseenquiry")
public class CourseEnquiry {

	// Registration Id is a primary key unique for each course enquiry
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer registrationId;

	// Customer Id is mapped to the enquiry
	@ManyToOne(cascade=CascadeType.ALL, targetEntity=Customer.class)
	@JoinColumn(name="customer_id")
	private Customer customerId;

	//Course Id of the course the enquiry is about
	//To be added after course table is added
	//@ManyToMany
	//@JoinColumn(name="courseid")
	@Column
	private Integer courseId;

	// Date when the enquiry is registered by the user
	@Column
	private Date enquiryDate;

	// Status of the enquiry
	@ManyToOne
	@JoinColumn(name="status_id")
	private EnquiryStatus enquiryStatus;

	public CourseEnquiry() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CourseEnquiry(Integer registrationId, Customer customerId, Integer courseId, Date enquiryDate,
			EnquiryStatus enquiryStatus) {
		super();
		this.registrationId = registrationId;
		this.customerId = customerId;
		this.courseId = courseId;
		this.enquiryDate = enquiryDate;
		this.enquiryStatus = enquiryStatus;
	}

	public Integer getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(Integer registrationId) {
		this.registrationId = registrationId;
	}

	public Customer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public Date getEnquiryDate() {
		return enquiryDate;
	}

	public void setEnquiryDate(Date enquiryDate) {
		this.enquiryDate = enquiryDate;
	}

	public EnquiryStatus getEnquiryStatus() {
		return enquiryStatus;
	}

	public void setEnquiryStatus(EnquiryStatus enquiryStatus) {
		this.enquiryStatus = enquiryStatus;
	}

	@Override
	public String toString() {
		return "CourseEnquiry [registrationId=" + registrationId + ", customerId=" + customerId + ", courseId="
				+ courseId + ", enquiryDate=" + enquiryDate + ", enquiryStatus=" + enquiryStatus + "]";
	}
	
}
