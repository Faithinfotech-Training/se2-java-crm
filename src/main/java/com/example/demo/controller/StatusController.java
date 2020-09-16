package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Status;
import com.example.demo.service.StatusServiceImp;

@RestController
@RequestMapping("api/status")
public class StatusController {
	@Autowired
	StatusServiceImp statusServiceImp;
	
	//get all status
	@GetMapping("/all")
	List<Status> getStatus() {
		return statusServiceImp.findAll();
	}
}
