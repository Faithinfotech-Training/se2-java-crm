/**
 * 
 */
package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Status;

public interface StatusDAO {
	
//  Get List of all status
	public List<Status> findAllStatus();
//  Find Status by id
	public Status findStatusById(int theId);
	
//	Save status
	public void saveStatus(Status status);
//	Delete status
	public Status deleteStatusById(int id);
	
}
