package com.entity;

import com.common.Entry;

@Entry
public class Results
{
	private Integer id;
	private String time;
	private Integer greate;
	private Integer state;
	private Questions questions;
	private Integer clazz;
	private User user;

	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer id)
	{
		this.id=id;
	}
	public String getTime()
	{
		return this.time;
	}
	public void setTime(String time)
	{
		this.time=time;
	}
	public Integer getGreate()
	{
		return this.greate;
	}
	public void setGreate(Integer greate)
	{
		this.greate=greate;
	}
	public Integer getState()
	{
		return this.state;
	}
	public void setState(Integer state)
	{
		this.state=state;
	}
	public Questions getQuestions()
	{
		return this.questions;
	}
	public void setQuestions(Questions questions)
	{
		this.questions=questions;
	}
	public Integer getClazz()
	{
		return this.clazz;
	}
	public void setClazz(Integer clazz)
	{
		this.clazz=clazz;
	}
	public User getUser()
	{
		return this.user;
	}
	public void setUser(User user)
	{
		this.user=user;
	}

}