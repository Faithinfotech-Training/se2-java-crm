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
	
	@Column(nullable = false , length = 50)
	private String domain;

	@ManyToOne
	@JoinColumn(name = "accessId")
	private AccessL accessL;

	@ManyToOne
	@JoinColumn(name = "statusId")
	private Status status;

	@ManyToOne
	@JoinColumn(name = "qualificationId")
	private Qualification qualification;

//	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinTable(name = "course_qualification",
//		joinColumns = { @JoinColumn(name = "course_id")},
//		inverseJoinColumns = { @JoinColumn (name = "qualification_id")})
//	private Set<Qualification> qualifications = new HashSet<>();

	public Course() {
		super();
	}

	public Course(String courseName, String description, int fees, int scoreCriteria, int ageCriteria, String duration,
			String domain, AccessL accessL, Status status, Qualification qualification) {
		super();
		this.courseName = courseName;
		this.description = description;
		this.fees = fees;
		this.scoreCriteria = scoreCriteria;
		this.ageCriteria = ageCriteria;
		this.duration = duration;
		this.domain = domain;
		this.accessL = accessL;
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

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public AccessL getAccessId() {
		return accessL;
	}

	public void setAccessId(AccessL accessL) {
		this.accessL = accessL;
	}

	public Status getStatusId() {
		return status;
	}

	public void setStatusId(Status status) {
		this.status = status;
	}

	public Qualification  getQualificationId() {
		return qualification;
	}

	public void setQualificationId(Qualification qualification) {
		this.qualification = qualification;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", description=" + description
				+ ", fees=" + fees + ", scoreCriteria=" + scoreCriteria + ", ageCriteria=" + ageCriteria + ", duration="
				+ duration + ", domain=" + domain + ", access=" + accessL + ", status=" + status
				+ ", qualification=" + qualification + "]";
	}

}
