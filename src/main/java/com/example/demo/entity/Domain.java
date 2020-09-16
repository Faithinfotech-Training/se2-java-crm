package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Domain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int domainId;
	
	@Column(nullable = false , length = 50)
	private String domainName;
	
	public Domain() {
		super();
	}

	public Domain(String domainName) {
		super();
		this.domainName = domainName;
	}

	public int getDomainId() {
		return domainId;
	}

	public void setDomainId(int domainId) {
		this.domainId = domainId;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	
	@Override
	public String toString() {
		return "Domain [domainId=" + domainId + ", domainName=" + domainName
				+ "]";
	}

}
