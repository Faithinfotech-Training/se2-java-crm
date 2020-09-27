package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="resource_enquiry_status")
@Table(name="resource_enquiry_status")
public class ResourceEnquiryStatus {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer statusId;
	
	@Column(length=20)
	private String statusValue;

	
	
	public ResourceEnquiryStatus() {
		super();
	}

	public ResourceEnquiryStatus(Integer statusId, String statusValue) {
		super();
		this.statusId = statusId;
		this.statusValue = statusValue;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getStatusValue() {
		return statusValue;
	}

	public void setStatusValue(String statusValue) {
		this.statusValue = statusValue;
	}

	@Override
	public String toString() {
		return "ResourceEnquiryStatus [statusId=" + statusId + ", statusValue=" + statusValue + "]";
	}

}
