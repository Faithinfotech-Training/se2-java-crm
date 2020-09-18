package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="users")

public class Users

{
	
	@Id
	@Column(name="userid")
  private int userid;
	
	@Column(name="username")
  private String username;
	
	@ManyToOne
	@JoinColumn(name="roleid")
  private Role role;
	@Override
	public String toString() {
		return "Users [userid=" + userid + ", username=" + username + ", role=" + role + ", email=" + email
				+ ", phoneno=" + phoneno + ", dateofjoining=" + dateofjoining + "]";
	}
	@Column(name="email")
  private String email;
	@Column(name="phoneno")
  private String phoneno;
	@Column(name="dateofjoining")
  private Date dateofjoining;
	
	public Users()
	{
		
	}
	
	public Users(int userid, String username, Role role, String email, String phoneno, Date dateofjoining) {
		super();
		this.userid = userid;
		this.username = username;
		this.role = role;
		this.email = email;
		this.phoneno = phoneno;
		this.dateofjoining = dateofjoining;
	}
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public Date getDateofjoining() {
		return dateofjoining;
	}
	public void setDateofjoining(Date dateofjoining) {
		this.dateofjoining = dateofjoining;
	}
}
