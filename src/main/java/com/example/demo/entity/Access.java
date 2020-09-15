package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AccessTable")
public class Access {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer accessId;
	
	@Column(nullable=false,length=20)
	private String accessType;

	public Access(Integer accessId, String accessType) {
		super();
		this.accessId = accessId;
		this.accessType = accessType;
	}

	public Access() {
		super();
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

	@Override
	public String toString() {
		return "Access [accessId=" + accessId + ", accessType=" + accessType + "]";
	}
	
}
