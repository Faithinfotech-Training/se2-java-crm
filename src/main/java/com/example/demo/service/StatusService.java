package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Status;

@Service
public interface StatusService {
	//get all status
	public List<Status> findAll();
	//get status by id
	public Status findStatusById(int theId);
	//create status
	public void saveStatus(Status status);
	//delete status
	public void deleteStatusById(int id);

}
