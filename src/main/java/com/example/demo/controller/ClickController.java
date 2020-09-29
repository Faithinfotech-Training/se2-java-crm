package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Access;
import com.example.demo.entity.Clickenquiry;
import com.example.demo.entity.Course;
import com.example.demo.service.AccessService;
import com.example.demo.service.ClickService;

@RestController
@CrossOrigin
@RequestMapping("/api/enquiry")
public class ClickController {

	private ClickService clickService;
	
	@Autowired
	public ClickController(ClickService clickService) {
		this.clickService = clickService;
	}

	//list of all access
	@GetMapping("/click")
	public List<Clickenquiry> findClick() {
		return clickService.findAllClickByDate();
	}
	@PostMapping("/click")
	public Clickenquiry addEnquiry(@RequestBody Clickenquiry clickenquiry) {
		clickService.save(clickenquiry);
		return clickenquiry;
	}
	
}
