package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.AccessDAO;
import com.example.demo.dao.ClickDAO;
import com.example.demo.entity.Clickenquiry;


@Service
public class ClickServiceImpl implements ClickService {

	private ClickDAO clickDAO;
	@Autowired
	public ClickServiceImpl(ClickDAO clickDAO) {
		this.clickDAO = clickDAO;
	}

	
	@Override
	public List<Clickenquiry> findAllClickByDate() {
	
		return clickDAO.findAllByClickDate();
	}


	@Transactional
	@Override
	public void save(Clickenquiry clickenquiry) {
	  clickDAO.save(clickenquiry);
	}

}
