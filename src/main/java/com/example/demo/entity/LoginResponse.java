package com.example.demo.entity;

public class LoginResponse {
 boolean success;
 String role;
 
 public LoginResponse()
 {
	 
 }
 
public boolean isSuccess() {
	return success;
}
public void setSuccess(boolean success) {
	this.success = success;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}

 
}
