package com.entity;

import com.common.Entry;

@Entry
public class Questions
{
	private Integer id;
	private String selects;
	private String answer;
	private String question;

	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer id)
	{
		this.id=id;
	}
	public String getSelects()
	{
		return this.selects;
	}
	public void setSelects(String selects)
	{
		this.selects=selects;
	}
	public String getAnswer()
	{
		return this.answer;
	}
	public void setAnswer(String answer)
	{
		this.answer=answer;
	}
	public String getQuestion()
	{
		return this.question;
	}
	public void setQuestion(String question)
	{
		this.question=question;
	}

}