package com.example.demo.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//  Login class to map to login table in database

@Entity
@Table(name="login")
public class Login {
    
	@Id
	@Column(name="loginid")
	private int loginId;
	
	@Column(name="username")
	private String userName;
	
	@Column(name="email")
	private String emailId;
	
	@Column(name="password")
	private String password;
	
	@ManyToOne
	@JoinColumn(name="userid")
	private Users user;

	//default constructor
	public Login()
	{
		
	}
	public Login(int loginId, String userName, String emailId, String password, Users user) {
		super();
		this.loginId = loginId;
		this.userName = userName;
		this.emailId = emailId;
		this.password = password;
		this.user = user;
	}

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
}