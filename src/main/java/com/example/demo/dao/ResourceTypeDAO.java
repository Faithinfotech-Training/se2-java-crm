/**
 * 
 */
package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.ResourceType;

public interface ResourceTypeDAO {
	
//  Get List of all resources
	public List<ResourceType> findAllResourceType();
//  Find ResourceType by id
	public ResourceType findResourceTypeById(int theId);
	
//	Save resources
	public void saveResourceType(ResourceType resourceType);
//	Delete resources
	public ResourceType deleteResourceTypeById(int id);
	
}
