package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Clickenquiry;

public interface ClickDAO {

	public List<Clickenquiry> findAllByClickDate();

	public void save(Clickenquiry clickenquiry);
}
