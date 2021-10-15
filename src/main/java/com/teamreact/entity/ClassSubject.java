package com.teamreact.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "class_subject")
public class ClassSubject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne()
	@JoinColumn(name = "id_class")
	@Id
	private Class classRoom;
	
	@ManyToOne()
	@JoinColumn(name = "id_subject")
	@Id
	private Subject subject;

	public Class getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(Class classRoom) {
		this.classRoom = classRoom;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
}
