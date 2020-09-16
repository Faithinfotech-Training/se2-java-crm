package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Login;

public interface LoginDAO {
  
	public String login(String username,String password);

	List<Login> getL();
	
}
