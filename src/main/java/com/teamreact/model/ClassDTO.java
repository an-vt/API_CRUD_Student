package com.teamreact.model;

public class ClassDTO {
	private int id;
	private String name;
	
	public ClassDTO() {
		super();
	}

	public ClassDTO(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
	
}
