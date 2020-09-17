package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.LoginDAO;
import com.example.demo.entity.CourseEnquiry;
import com.example.demo.entity.Login;
import com.example.demo.entity.ResourceEnquiry;
import com.example.demo.service.LoginService;
import com.example.demo.service.RSalespipeline;
import com.example.demo.service.CSalespipelineService;

@RestController
@RequestMapping("/api")

public class ResourceSalespipelineController {
	
			private RSalespipeline salespipelineService ;
		
		@Autowired
		public  ResourceSalespipelineController(RSalespipeline salespipelineService)
		{
			this.salespipelineService=salespipelineService;
		}
		
		
		@RequestMapping(method=RequestMethod.GET,value="/stats/resource/salespipeline")
		public List<ResourceEnquiry>viewSalespipeline()
		{
			 System.out.println("SalesPipelineChart");
		return salespipelineService.viewResourcesSalesPipeline();

		} 
		
	

}
