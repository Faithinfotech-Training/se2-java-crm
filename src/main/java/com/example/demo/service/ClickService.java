package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Access;
import com.example.demo.entity.Clickenquiry;


public interface ClickService {

	public List<Clickenquiry> findAllClickByDate();

	public void save(Clickenquiry clickenquiry);
	
}
