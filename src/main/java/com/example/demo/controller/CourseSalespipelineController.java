package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.LoginDAO;
import com.example.demo.entity.CourseEnquiry;
import com.example.demo.entity.Login;
import com.example.demo.service.LoginService;
import com.example.demo.service.CSalespipelineService;

@CrossOrigin
@RestController
@RequestMapping("/api")

public class CourseSalespipelineController {
	
				private CSalespipelineService salespipelineService ;
		
		@Autowired
		public  CourseSalespipelineController(CSalespipelineService salespipelineService)
		{
			this.salespipelineService=salespipelineService;
		}
		
		
		@RequestMapping(method=RequestMethod.GET,value="/stats/course/salespipeline")
		public List<CourseEnquiry> viewSalespipeline()
		{
			 System.out.println("SalesPipelineChart");	
		 return salespipelineService.viewCourseSalesPipeline();
		
		} 

}