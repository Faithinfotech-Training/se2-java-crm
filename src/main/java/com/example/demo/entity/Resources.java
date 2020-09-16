package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Resources {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer resourceId;
	
	@Column(nullable=false,length=20)
	private String resourceName;
	
	@Column(nullable=false,length=200)
	private String resourceDescription;
	
	@Column(nullable=false,length=10)
	private Integer capacity;
	
	@Column(nullable=false,length=10)
	private Integer fees;
	
//	Resources of Resource
//	such as "Available" or "Not Available"
	@ManyToOne
	@JoinColumn(name="statusId")
	private Status status;
	
	@ManyToOne
	@JoinColumn(name="accessId")
	private Access access;

	@ManyToOne
	@JoinColumn(name="resourceTypeId")
	private ResourceType resourceType;

	public Resources() {
		super();
	}

	public Resources(String resourceName, String resourceDescription, Integer capacity, Integer fees, Status status,
			Access access, ResourceType resourceType) {
		super();
		this.resourceName = resourceName;
		this.resourceDescription = resourceDescription;
		this.capacity = capacity;
		this.fees = fees;
		this.status = status;
		this.access = access;
		this.resourceType = resourceType;
	}

	public Integer getResourceId() {
		return resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceDescription() {
		return resourceDescription;
	}

	public void setResourceDescription(String resourceDescription) {
		this.resourceDescription = resourceDescription;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Integer getFees() {
		return fees;
	}

	public void setFees(Integer fees) {
		this.fees = fees;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Access getAccess() {
		return access;
	}

	public void setAccess(Access access) {
		this.access = access;
	}

	public ResourceType getResourceType() {
		return resourceType;
	}

	public void setResourceType(ResourceType resourceType) {
		this.resourceType = resourceType;
	}

	@Override
	public String toString() {
		return "Resources [resourceId=" + resourceId + ", resourceName=" + resourceName + ", resourceDescription="
				+ resourceDescription + ", capacity=" + capacity + ", fees=" + fees + ", status=" + status + ", access="
				+ access + ", resourceType=" + resourceType + "]";
	}
	
}




