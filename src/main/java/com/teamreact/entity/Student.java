package com.teamreact.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
//@NoArgsConstructor
//@RequiredArgsConstructor
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name" ,columnDefinition = "")
	private String name;
	
	@Column(name = "age")
	private int age;
	
	@ManyToOne()
	@JoinColumn(name = "id_class")
	private int classId;
}
