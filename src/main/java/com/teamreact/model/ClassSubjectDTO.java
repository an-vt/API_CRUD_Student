package com.teamreact.model;

public class ClassSubjectDTO {
	private long classId;
	private long subjectId;
	
	public ClassSubjectDTO() {
		super();
	}
	
	public ClassSubjectDTO(long classId, long subjectId) {
		super();
		this.classId = classId;
		this.subjectId = subjectId;
	}

	public long getClassId() {
		return classId;
	}
	
	public void setClassId(long classId) {
		this.classId = classId;
	}
	
	public long getSubjectId() {
		return subjectId;
	}
	
	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}
}
