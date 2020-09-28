package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CourseEnquiry;
import com.example.demo.entity.ResourceEnquiry;
import com.example.demo.entity.ResourceEnquiryStatusDTO;
import com.example.demo.service.CourseTableChartService;
import com.example.demo.service.ResourceTableChartService;

@CrossOrigin
@RestController
@RequestMapping("/api")

public class ResourceTableChartController {
	
				private ResourceTableChartService  resourceTableChartService ;
		
		@Autowired
		public  ResourceTableChartController( ResourceTableChartService  resourceTableChartService)
		{
			this.resourceTableChartService  =resourceTableChartService;
		}
		
		
		@RequestMapping(method=RequestMethod.GET,value="/stats/resource/table")
		public List<ResourceEnquiryStatusDTO> viewResourceTable()
		{
			
		 return resourceTableChartService.viewResourceTable();
		
		} 

}