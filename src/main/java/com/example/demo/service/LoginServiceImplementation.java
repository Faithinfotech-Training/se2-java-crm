package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.LoginDAO;
import com.example.demo.dao.LoginDAOImplementation;
import com.example.demo.entity.Login;

@Service
public class LoginServiceImplementation implements LoginService{
	 
	private LoginDAO loginDAO;
	private LoginDAOImplementation loginDAOImp;
	
	@Autowired
	public LoginServiceImplementation(@Qualifier("loginDAOImplementation") LoginDAO loginDAO) {
		super();
		this.loginDAO =loginDAO;
	}
	@Override
	@Transactional
	public String login(String username, String password) {
		
	 return loginDAO.login(username, password);
	}
	@Override
	@Transactional
	public List<Login> getL() {
		
		return loginDAO.getL() ;
	}

}
