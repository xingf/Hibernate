package com.xw.domain;

import java.io.Serializable;
import java.util.Date;


//�������ǵ�domain��������ƾ��Ƕ�Ӧ�������ĸ��д
public class Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7358465326081900528L;
	private Integer id;
	private String name;
	private String email;
	private Date hiredDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getHiredDate() {
		return hiredDate;
	}
	public void setHiredDate(Date hiredDate) {
		this.hiredDate = hiredDate;
	}
	
	
}
