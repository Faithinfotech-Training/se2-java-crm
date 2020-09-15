package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.ResourceType;

@Service
public interface ResourceTypeService {
	public List<ResourceType> findAll();
	public ResourceType findResourceTypeById(int theId);
	public void saveResourceType(ResourceType status);
	public void deleteResourceTypeById(int id);
}
