package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name="clickenquiry")
@Table(name = "clickenquiry")
public class Clickenquiry {

	public Clickenquiry()
	{
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer clickid;
	
	public Integer getClickid() {
		return clickid;
	}

	public void setClickid(Integer clickid) {
		this.clickid = clickid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Column(name="dateClick")
	private Date date;
	
	@Column(name="page")
	private String page;
	
	@Column(name="count")
	private Integer count;
}
