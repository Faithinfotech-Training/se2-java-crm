package com.example.demo.entity;

public class CourseEnquiryStatusDTO {

	
	String statusValue;
	int statusCount;
	
	public CourseEnquiryStatusDTO()
	{
		
	}
	public String getStatusValue() {
		return statusValue;
	}
	public void setStatusValue(String statusValue) {
		this.statusValue = statusValue;
	}
	public int getStatusCount() {
		return statusCount;
	}
	public void setStatusCount(int statusCount) {
		this.statusCount = statusCount;
	}
}
