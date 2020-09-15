package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Status;

@Service
public interface StatusService {
	public List<Status> findAll();
	public Status findStatusById(int theId);
	public void saveStatus(Status status);
	public void deleteStatusById(int id);
}
