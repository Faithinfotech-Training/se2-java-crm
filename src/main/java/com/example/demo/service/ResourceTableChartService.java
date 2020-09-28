package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.CourseEnquiry;
import com.example.demo.entity.ResourceEnquiry;
import com.example.demo.entity.ResourceEnquiryStatusDTO;

public interface ResourceTableChartService {

	List<ResourceEnquiryStatusDTO> viewResourceTable();

}
