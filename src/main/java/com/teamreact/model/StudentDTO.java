package com.teamreact.model;

import java.util.Date;

public class StudentDTO {
	private long id;
	private String name;
	private int age;
	private String address;
	private String gender;
	private String dOB;
	private ClassDTO classDTO;
	
	public StudentDTO() {
		super();
	}

	public StudentDTO(long id, String name, int age, String address, String gender, String dOB, ClassDTO classDTO) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.gender = gender;
		this.dOB = dOB;
		this.classDTO = classDTO;
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

	public String getdOB() {
		return dOB;
	}

	public void setdOB(String dOB) {
		this.dOB = dOB;
	}

	public ClassDTO getClassDTO() {
		return classDTO;
	}

	public void setClassDTO(ClassDTO classDTO) {
		this.classDTO = classDTO;
	}
	
}
