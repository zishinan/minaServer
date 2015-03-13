package com.service;

import java.util.List;

import com.entity.User;

public interface UserService
{
	public boolean add(User user);

	public boolean delete(Long id);

	public boolean update(User user);

	public User getById(Long id);

	public List<User> list();
}