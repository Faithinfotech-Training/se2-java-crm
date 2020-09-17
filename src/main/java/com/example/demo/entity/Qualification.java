package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Qualification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int qualificationId;
	
	@Column(nullable = false , length = 50)
	private String qualificationName;
	
	@Column(nullable = false , length = 5)
	private String percentage;

//	@ManyToMany(mappedBy = "courses", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER )
//	private Set<Course> courses = new HashSet<>();
			
	@ManyToMany(cascade = { CascadeType.MERGE})
	@JoinTable(name = "qualification_course", joinColumns = {
			@JoinColumn(name = "qualification_id") }, 
			inverseJoinColumns = { @JoinColumn(name = "course_id") })
	@JsonBackReference
	private Set<Course> courses = new HashSet<>();
	
	public Qualification() {
		super();
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public Qualification(String qualificationName, String percentage) {
		super();
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

	@Override
	public String toString() {
		return "Qualification [qualificationId=" + qualificationId + ", qualificationName=" + qualificationName
				+ ", percentage=" + percentage + ", courses=" + courses + "]";
	}


	

}
