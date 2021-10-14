package com.teamreact.model;

public class ResultDTO {
	private long studentId;
	private long subjectId;
	private float point;
	
	public ResultDTO() {
		super();
	}

	public ResultDTO(long studentId, long subjectId, float point) {
		super();
		this.studentId = studentId;
		this.subjectId = subjectId;
		this.point = point;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public float getPoint() {
		return point;
	}

	public void setPoint(float point) {
		this.point = point;
	}
}
