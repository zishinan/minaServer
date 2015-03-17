package com.entity;

import com.common.Entry;

@Entry
public class User
{
	private Long id;
	private String schNum;
	private String name;
	private Integer type;
	private String password;
	private String clazz;

	public Long getId()
	{
		return this.id;
	}
	public void setId(Long id)
	{
		this.id=id;
	}
	public String getSchNum()
	{
		return this.schNum;
	}
	public void setSchNum(String schNum)
	{
		this.schNum=schNum;
	}
	public String getName()
	{
		return this.name;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public Integer getType()
	{
		return this.type;
	}
	public void setType(Integer type)
	{
		this.type=type;
	}
	public String getPassword()
	{
		return this.password;
	}
	public void setPassword(String password)
	{
		this.password=password;
	}
	public String getClazz()
	{
		return this.clazz;
	}
	public void setClazz(String clazz)
	{
		this.clazz=clazz;
	}

}