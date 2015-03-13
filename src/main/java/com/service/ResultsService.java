package com.service;

import java.util.List;

import com.entity.Results;

public interface ResultsService
{
	public boolean add(Results results);

	public boolean delete(Long id);

	public boolean update(Results results);

	public Results getById(Long id);

	public List<Results> list();
}