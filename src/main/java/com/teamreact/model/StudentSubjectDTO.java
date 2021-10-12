package com.teamreact.model;

public class StudentSubjectDTO {
	private int id;
	private int studentId;
	private int subjectId;
	public StudentSubjectDTO() {
		super();
	}
	public StudentSubjectDTO(int id, int studentId, int subjectId) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.subjectId = subjectId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	
	
}
