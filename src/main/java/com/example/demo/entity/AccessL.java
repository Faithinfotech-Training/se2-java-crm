package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AccessL {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int accessId;
    
	@Column(nullable = false , length = 50)
    private String accessType;

	public AccessL() {
	}

	public AccessL(Integer accessId, String accessType) {
		super();
		this.accessId = accessId;
		this.accessType = accessType;
	}

	public Integer getAccessId() {
		return accessId;
	}

	public void setAccessId(Integer accessId) {
		this.accessId = accessId;
	}

	public String getAccessType() {
		return accessType;
	}

	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}
	
}
