package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Status {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer statusId;
	
	@Column(nullable=false,length=50)
	private String statusType;

	public Status(Integer statusId, String statusType) {
		super();
		this.statusId = statusId;
		this.statusType = statusType;
	}

	public Status() {
		super();
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getStatusType() {
		return statusType;
	}

	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}

	@Override
	public String toString() {
		return "Status [statusId=" + statusId + ", statusType=" + statusType + "]";
	}
	
	
}
