package com.dao;

import com.common.GenericDao;
import com.entity.User;

public interface UserDao extends GenericDao<User>
{
	public User getUserBySchnumAndPassword(String schNum, String password);

	public void remove(String name);

	public User getUserBySchnum(String name);
}