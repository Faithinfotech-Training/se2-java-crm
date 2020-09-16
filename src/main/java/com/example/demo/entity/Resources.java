package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Resources {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer resourceId;
	
	@Column(nullable=false,length=20)
	private String resourceName;

	@ManyToOne
	@JoinColumn(name="resourceTypeId")
	private ResourceType resourceType;
	
	
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
	Status status;
	
	@ManyToOne
	@JoinColumn(name="accessId")
	Access access;

	public Resources() {
		super();
	}

	public Resources(Integer resourceId, String resourceName, ResourceType resourceType, String resourceDescription,
			Integer capacity, Integer fees, Status status, Access access) {
		super();
		this.resourceId = resourceId;
		this.resourceName = resourceName;
		this.resourceType = resourceType;
		this.resourceDescription = resourceDescription;
		this.capacity = capacity;
		this.fees = fees;
		this.status = status;
		this.access = access;
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

	public ResourceType getResourceType() {
		return resourceType;
	}

	public void setResourceType(ResourceType resourceType) {
		this.resourceType = resourceType;
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

	@Override
	public String toString() {
		return "Resources [resourceId=" + resourceId + ", resourceName=" + resourceName + ", resourceType="
				+ resourceType + ", resourceDescription=" + resourceDescription + ", capacity=" + capacity + ", fees="
				+ fees + ", status=" + status + ", access=" + access + "]";
	}




}




