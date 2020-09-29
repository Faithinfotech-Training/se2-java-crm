package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.CourseLeadResponseDTO;
import com.example.demo.entity.ResourceEnquiry;

public interface RSalespipeline {

	public List<ResourceEnquiry> viewResourcesSalesPipeline();

	public List<CourseLeadResponseDTO> viewResourceLeadsSalesPipeline();
}
