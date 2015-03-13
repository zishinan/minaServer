package com.entity;

import com.common.Entry;

@Entry
public class User
{
	private Integer id;
	private String phone;
	private Integer greate;
	private String schNum;
	private String name;
	private Integer type;
	private String password;
	private Integer clazz;

	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer id)
	{
		this.id=id;
	}
	public String getPhone()
	{
		return this.phone;
	}
	public void setPhone(String phone)
	{
		this.phone=phone;
	}
	public Integer getGreate()
	{
		return this.greate;
	}
	public void setGreate(Integer greate)
	{
		this.greate=greate;
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
	public Integer getClazz()
	{
		return this.clazz;
	}
	public void setClazz(Integer clazz)
	{
		this.clazz=clazz;
	}

}