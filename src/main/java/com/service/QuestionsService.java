package com.service;

import java.util.List;

import com.entity.Questions;

public interface QuestionsService
{
	public boolean add(Questions questions);

	public boolean delete(Long id);

	public boolean update(Questions questions);

	public Questions getById(Long id);

	public List<Questions> list();
}