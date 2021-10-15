package com.teamreact.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.NonNull;

@Entity
@Table(name = "student")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name", columnDefinition = "NVARCHAR(50)")
	@NotNull
	private String name;
	
	@Column(name = "age")
	@NotNull
	private int age;
	
	@Column(name = "address", columnDefinition = "NVARCHAR(50)")
	@NotNull
	private String address;
	
	@Column(name = "gender", columnDefinition = "NVARCHAR(50)")
	@NotNull
	private String gender;
	
	@Column(name = "dOB", columnDefinition = "date")
	@NotNull
	private Date dOB;
	
	@ManyToOne()
	@JoinColumn(name = "id_class")
	private Class classRoom;

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

	public Class getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(Class classRoom) {
		this.classRoom = classRoom;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
