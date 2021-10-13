//package com.teamreact.entity;
//
//import java.io.Serializable;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.NonNull;
//import lombok.RequiredArgsConstructor;
//
//
//@Data
//@Entity
//@Table(name = "result")
//@NoArgsConstructor
//@RequiredArgsConstructor
//public class Result implements Serializable{
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@NonNull
//	private int id;
//	
//	@OneToMany(fetch = FetchType.EAGER)
//	@Column(name = "student_id")
//	private int studentId;
//	
//	@OneToOne(mappedBy = "subject")
//	@Column(name = "subject_id")
//	private int subjectId;
//	
//	@Column(name = "point")
//	private double point;
//}
