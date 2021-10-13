package com.teamreact.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentDTO {
	private int id;
	private String name;
	
//	@JsonProperty("age")
	private int age;
	
	private ClassDTO classDTO;
	
	public StudentDTO() {
		super();
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
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

	public ClassDTO getClassDTO() {
		return classDTO;
	}

	public void setClassDTO(ClassDTO classDTO) {
		this.classDTO = classDTO;
	}

}
