package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Resources;

@Service
public interface ResourcesService {
	public List<Resources> findAll();
	public Resources findResourcesById(int theId);
	public void saveResources(Resources resources);
	public void deleteResourcesById(int id);
}
