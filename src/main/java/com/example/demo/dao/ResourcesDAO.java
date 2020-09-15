/**
 * 
 */
package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Resources;

public interface ResourcesDAO {
	
//  Get List of all resources
	public List<Resources> findAllResources();
//  Find Resources by id
	public Resources findResourcesById(int theId);
	
//	Save resources
	public void saveResources(Resources resources);
//	Delete resources
	public Resources deleteResourcesById(int id);
	
}
