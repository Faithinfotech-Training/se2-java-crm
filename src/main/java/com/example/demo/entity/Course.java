<<<<<<< HEAD
package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int courseId;

	@Column(nullable = false , length = 50)
	private String courseName;
	
	@Column(nullable = false , length = 50)
	private String description;
	
	@Column(nullable = false , length = 50)
	private int fees;
	
	@Column(nullable = false , length = 50)
	private int scoreCriteria;
	
	@Column(nullable = false , length = 50)
	private int ageCriteria;
	
	@Column(nullable = false , length = 50)
	private String duration;
	
	@ManyToOne
	@JoinColumn(name = "domainId")
	private Domain domain;

	@ManyToOne
	@JoinColumn(name = "accessId")
	private Access access;

	@ManyToOne
	@JoinColumn(name = "statusId")
	private Status status;

	@ManyToOne
	@JoinColumn(name = "qualificationId")
	private Qualification qualification;

//	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
//	@JoinTable(name = "Course_Qualification",
//		joinColumns = { @JoinColumn(name = "course_id")},
//		inverseJoinColumns = { @JoinColumn (name = "qualification_id")})
//	private Set<Qualification> qualifications = new HashSet<>();

	public Course() {
		super();
	}

	public Course(String courseName, String description, int fees, int scoreCriteria, int ageCriteria, String duration,
			Domain domain, Access access, Status status, Qualification qualification) {
		super();
		this.courseName = courseName;
		this.description = description;
		this.fees = fees;
		this.scoreCriteria = scoreCriteria;
		this.ageCriteria = ageCriteria;
		this.duration = duration;
		this.domain = domain;
		this.access = access;
		this.status = status;
		this.qualification = qualification;
	}


	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	public int getScoreCriteria() {
		return scoreCriteria;
	}

	public void setScoreCriteria(int scoreCriteria) {
		this.scoreCriteria = scoreCriteria;
	}

	public int getAgeCriteria() {
		return ageCriteria;
	}

	public void setAgeCriteria(int ageCriteria) {
		this.ageCriteria = ageCriteria;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	public Access getAccess() {
		return access;
	}

	public void setAccess(Access access) {
		this.access = access;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Qualification getQualification() {
		return qualification;
	}

	public void setQualification(Qualification qualification) {
		this.qualification = qualification;
	}

//	public Set<Qualification> getQualifications() {
//		return qualifications;
//	}
//
//	public void setQualifications(Set<Qualification> qualifications) {
//		this.qualifications = qualifications;
//	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", description=" + description
				+ ", fees=" + fees + ", scoreCriteria=" + scoreCriteria + ", ageCriteria=" + ageCriteria + ", duration="
				+ duration + ", domain=" + domain + ", access=" + access + ", status=" + status + ", qualification="
				+ qualification + "]";
	}

	


}
=======
package com.example.demo.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int courseId;

	@Column(nullable = false , length = 50)
	private String courseName;
	
	@Column(nullable = false , length = 50)
	private String description;
	
	@Column(nullable = false , length = 50)
	private int fees;
	
	@Column(nullable = false , length = 50)
	private int scoreCriteria;
	
	@Column(nullable = false , length = 50)
	private int ageCriteria;
	
	@Column(nullable = false , length = 50)
	private String duration;
	
	@ManyToOne
	@JoinColumn(name = "domainId")
	private Domain domain;

	@ManyToOne
	@JoinColumn(name = "accessId")
	private Access access;

	@ManyToOne
	@JoinColumn(name = "statusId")
	private Status status;

//	@ManyToOne
//	@JoinColumn(name = "qualificationId")
//	private Qualification qualification;

//	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
//	@JoinTable(name = "Course_Qualification",
//		joinColumns = { @JoinColumn(name = "course_id")},
//		inverseJoinColumns = { @JoinColumn (name = "qualification_id")})
//	private Set<Qualification> qualifications = new HashSet<>();

	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
	@JoinTable(name = "qualification_course", joinColumns = {
			@JoinColumn(name = "course_id") }, inverseJoinColumns = { @JoinColumn(name = "qualification_id") })
	private Set<Qualification> qualifications = new HashSet<>();
	
//	@ManyToMany(mappedBy = "courses")
//	//@JsonManagedReference
//	private Set<Qualification> qualifications = new HashSet<>();
	
	public Course() {
		super();
	}

	public Course(String courseName, String description, int fees, int scoreCriteria, int ageCriteria, String duration,
			Domain domain, Access access, Status status, Set<Qualification> qualifications) {
		super();
		this.courseName = courseName;
		this.description = description;
		this.fees = fees;
		this.scoreCriteria = scoreCriteria;
		this.ageCriteria = ageCriteria;
		this.duration = duration;
		this.domain = domain;
		this.access = access;
		this.status = status;
		this.qualifications = qualifications;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	public int getScoreCriteria() {
		return scoreCriteria;
	}

	public void setScoreCriteria(int scoreCriteria) {
		this.scoreCriteria = scoreCriteria;
	}

	public int getAgeCriteria() {
		return ageCriteria;
	}

	public void setAgeCriteria(int ageCriteria) {
		this.ageCriteria = ageCriteria;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	public Access getAccess() {
		return access;
	}

	public void setAccess(Access access) {
		this.access = access;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Set<Qualification> getQualifications() {
		return qualifications;
	}

	public void setQualifications(Set<Qualification> qualifications) {
		this.qualifications = qualifications;
	}


}
>>>>>>> 5f19ed8f8d38ffa3256101883bb0c8f6c5603409
