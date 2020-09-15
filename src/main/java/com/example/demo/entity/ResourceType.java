package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ResourceType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer resourceTypeId;
	 
	@Column(nullable=false,length=50)
	private String resourceTypeString;

	public ResourceType(Integer resourceTypeId, String resourceTypeString) {
		super();
		this.resourceTypeId = resourceTypeId;
		this.resourceTypeString = resourceTypeString;
	}

	public ResourceType() {
		super();
	}

	public Integer getResourceTypeId() {
		return resourceTypeId;
	}

	public void setResourceTypeId(Integer resourceTypeId) {
		this.resourceTypeId = resourceTypeId;
	}

	public String getResourceTypeString() {
		return resourceTypeString;
	}

	public void setResourceTypeString(String resourceTypeString) {
		this.resourceTypeString = resourceTypeString;
	}

	@Override
	public String toString() {
		return "ResourceType [resourceTypeId=" + resourceTypeId + ", resourceTypeString=" + resourceTypeString + "]";
	}
	
	
	
}
