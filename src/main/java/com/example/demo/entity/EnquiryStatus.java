package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="enquirystatus")
public class EnquiryStatus {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer statusId;
	
	@Column(nullable=false, length=20)
	private String statusValue;

	public EnquiryStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EnquiryStatus(Integer statusId, String statusValue) {
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
		return "EnquiryStatus [statusId=" + statusId + ", statusValue=" + statusValue + "]";
	}
	
}
