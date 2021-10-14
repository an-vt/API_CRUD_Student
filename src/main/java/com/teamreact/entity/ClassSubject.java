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
	@Column(name = "id_class")
	@JoinColumn(name = "id_class")
	@Id
	private Class classRoom;
	
	@ManyToOne()
	@Column(name = "id_subject")
	@JoinColumn(name = "id_subject")
	@Id
	private Subject subject;

}
