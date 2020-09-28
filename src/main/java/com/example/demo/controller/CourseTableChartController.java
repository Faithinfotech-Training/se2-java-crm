package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CourseEnquiry;
import com.example.demo.entity.CourseEnquiryStatusDTO;
import com.example.demo.service.CourseTableChartService;

@CrossOrigin
@RestController
@RequestMapping("/api")

public class CourseTableChartController {
	
				private CourseTableChartService  courseTableChartService ;
		
		@Autowired
		public  CourseTableChartController( CourseTableChartService  courseTableChartService)
		{
			this.courseTableChartService =courseTableChartService ;
		}
		
		
		@RequestMapping(method=RequestMethod.GET,value="/stats/course/table")
		public List<CourseEnquiryStatusDTO> viewSalespipeline()
		{
			
		 return courseTableChartService.viewCourseTable();
		
		} 
		

}