package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Login;

public interface LoginService 
{

	public String login(String username,String password);

	List<Login> getL();
	
}
