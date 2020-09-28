package com.example.demo.entity;

public class CourseLeadResponseDTO {

	int totalCount;
	String lead;
	int leadCount;
	public CourseLeadResponseDTO() {
		super();
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public String getLead() {
		return lead;
	}
	public void setLead(String lead) {
		this.lead = lead;
	}
	public int getLeadCount() {
		return leadCount;
	}
	public void setLeadCount(int leadCount) {
		this.leadCount = leadCount;
	}
	@Override
	public String toString() {
		return "CourseLeadResponseDTO [totalCount=" + totalCount + ", lead=" + lead + ", leadCount=" + leadCount + "]";
	}
	
	
	
}
