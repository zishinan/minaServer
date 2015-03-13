package com.service.impl;

import java.util.List;

import com.dao.QuestionsDao;
import com.dao.impl.QuestionsDaoImpl;
import com.entity.Questions;
import com.service.QuestionsService;

public class QuestionsServiceImpl implements QuestionsService
{
	private static QuestionsDao questionsDao = new QuestionsDaoImpl();
	@Override
	public boolean add(Questions questions)
	{
		return questionsDao.add(questions);
	}
	@Override
	public boolean delete(Long id)
	{
		return questionsDao.delete(id);
	}
	@Override
	public boolean update(Questions questions)
	{
		return questionsDao.update(questions);
	}
	@Override
	public Questions getById(Long id)
	{
		return questionsDao.getById(id);
	}
	@Override
	public List<Questions> list()
	{
		return questionsDao.listQuery(null, null, null, null);
	}
}