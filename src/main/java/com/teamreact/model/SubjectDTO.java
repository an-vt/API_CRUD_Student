package com.teamreact.model;

import java.util.Date;

public class SubjectDTO {
	private long id;
	private String name;
	
	public SubjectDTO() {
		super();
	}

	public SubjectDTO(long id, String name) {
		super();
		this.id = id;
		this.name = name;
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
}
