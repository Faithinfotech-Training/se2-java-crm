package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Login;

// Login DAO Interface
public interface LoginDAO {
  
	//Method to check login credentials
	public String login(String username,String password);

	List<Login> getL();
	
}
