package com.service.impl;

import java.util.List;

import com.dao.ResultsDao;
import com.dao.impl.ResultsDaoImpl;
import com.entity.Results;
import com.service.ResultsService;

public class ResultsServiceImpl implements ResultsService
{
	private static ResultsDao resultsDao = new ResultsDaoImpl();
	@Override
	public boolean add(Results results)
	{
		return resultsDao.add(results);
	}
	@Override
	public boolean delete(Long id)
	{
		return resultsDao.delete(id);
	}
	@Override
	public boolean update(Results results)
	{
		return resultsDao.update(results);
	}
	@Override
	public Results getById(Long id)
	{
		return resultsDao.getById(id);
	}
	@Override
	public List<Results> list()
	{
		return resultsDao.listQuery(null, null, null, null);
	}
}