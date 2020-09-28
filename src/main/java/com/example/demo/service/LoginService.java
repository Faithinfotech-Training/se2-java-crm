package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Login;
import com.example.demo.entity.LoginResponse;

public interface LoginService 
{

	public LoginResponse login(String username,String password);

	List<Login> getL();
	
}
