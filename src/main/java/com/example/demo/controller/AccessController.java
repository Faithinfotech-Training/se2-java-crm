package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Access;
import com.example.demo.service.AccessService;

@CrossOrigin
@RestController

@RequestMapping("/api")
public class AccessController {
	private AccessService accessService;

	@Autowired
	public AccessController(AccessService accessService) {
		this.accessService = accessService;
	}

	//list of all access
	@GetMapping("/access")
	public List<Access> findAllAccesss() {
		return accessService.findAllAccess();
	}
}
