package com.teamreact.model;

public class ResultDTO {
	private int id;
	private int studentId;
	private int subjectId;
	private double point;
	public ResultDTO() {
		super();
	}
	public ResultDTO(int id, int studentId, int subjectId, double point) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.subjectId = subjectId;
		this.point = point;
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
	public double getPoint() {
		return point;
	}
	public void setPoint(double point) {
		this.point = point;
	}
	
	
}
