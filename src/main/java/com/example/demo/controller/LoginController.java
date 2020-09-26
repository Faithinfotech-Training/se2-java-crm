package com.example.demo.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.LoginDAO;
import com.example.demo.entity.Login;
import com.example.demo.entity.LoginInfo;
import com.example.demo.service.LoginService;


// Class to create login API
@CrossOrigin
@RestController
@RequestMapping("/api")

public class LoginController {
	
	// Login service
	private LoginService loginService;
	
	@Autowired
	public LoginController(LoginService loginService)
	{
		this.loginService=loginService;
	}
	
	//Just checking working of system
	/*@GetMapping("/")
	List<Login> getLogin() {
		
		
		LoginDAO loginServiceImplementation;
		return loginService.getL();
	} 
	*/
	
	@PostMapping(
			  value = "/login", consumes = "application/json")
	String LoginMethod(@RequestBody LoginInfo logininfo )
	{
	     String userName=logininfo.getUsername();
	     String password=logininfo.getPassword();
	     System.out.println(userName+password);
		return loginService.login(userName,password);
	}
	
}
