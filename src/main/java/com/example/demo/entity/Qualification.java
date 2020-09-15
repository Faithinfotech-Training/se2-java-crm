package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Qualification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int qualificationId;
	
	@Column(nullable = false , length = 50)
	private String qualificationName;
	
	@Column(nullable = false , length = 5)
	private String percentage;

//	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "courses")
//	private Set<Course> courses = new HashSet<>();
	

	public Qualification() {
		super();
	}

	public Qualification(String qualificationName, String percentage) {
		super();
	//	this.qualificationId = qualificationId;
		this.qualificationName = qualificationName;
		this.percentage = percentage;
	}

	public int getQualificationId() {
		return qualificationId;
	}

	public void setQualificationId(int qualificationId) {
		this.qualificationId = qualificationId;
	}

	public String getQualificationName() {
		return qualificationName;
	}

	public void setQualificationName(String qualificationName) {
		this.qualificationName = qualificationName;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

//	public Set<Course> getCourses() {
//		return courses;
//	}
//
//	public void setCourses(Set<Course> courses) {
//		this.courses = courses;
//	}

	@Override
	public String toString() {
		return "Qualification [qualificationId=" + qualificationId + ", qualificationName=" + qualificationName
				+ ", percentage=" + percentage +  "]";
	}

}
