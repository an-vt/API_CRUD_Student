package com.teamreact.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentDTO {
	private long id;
	private String name;
	private int age;
	private String address;
	private String gender;
	private Date dOB;
	
	public StudentDTO() {
		super();
	}

	public StudentDTO(long id, String name, int age, String address, String gender, Date dOB) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.gender = gender;
		this.dOB = dOB;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getdOB() {
		return dOB;
	}

	public void setdOB(Date dOB) {
		this.dOB = dOB;
	}
}
