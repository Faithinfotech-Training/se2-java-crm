package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Login;
import com.example.demo.entity.LoginResponse;

// Login DAO Interface
public interface LoginDAO {
  
	//Method to check login credentials
	public LoginResponse login(String username,String password);

	List<Login> getL();
	
}
