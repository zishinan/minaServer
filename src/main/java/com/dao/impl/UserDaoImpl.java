package com.dao.impl;

import java.util.List;

import com.common.GenericDaoImpl;
import com.dao.UserDao;
import com.entity.User;

public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao
{
	@Override
	public User getUserBySchnumAndPassword(String schNum,String password){
    	List<User> users = listQuery(" schNum = ? and password = ? and type = 3 ", new Object[]{schNum,password}, null, null);
    	if(users.size() > 0){
    		return users.get(0);
    	}
    	return null;
	}

	@Override
	public void remove(String schNum) {
		String sql = "delete from user where schNum = ?";
		update(sql, schNum);
	}

	@Override
	public User getUserBySchnum(String name) {
		List<User> users = listQuery(" schNum = ? ", new Object[]{name}, null, null);
		if(users.size()>0){
			return users.get(0);
		}
		return null;
	}
}