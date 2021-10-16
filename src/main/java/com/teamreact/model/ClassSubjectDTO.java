package com.teamreact.model;

public class ClassSubjectDTO {
	private ClassDTO classDTO;
	private SubjectDTO subjectDTO;
	
	public ClassSubjectDTO() {
		super();
	}

	public ClassSubjectDTO(ClassDTO classDTO, SubjectDTO subjectDTO) {
		super();
		this.classDTO = classDTO;
		this.subjectDTO = subjectDTO;
	}

	public ClassDTO getClassDTO() {
		return classDTO;
	}

	public void setClassDTO(ClassDTO classDTO) {
		this.classDTO = classDTO;
	}

	public SubjectDTO getSubjectDTO() {
		return subjectDTO;
	}

	public void setSubjectDTO(SubjectDTO subjectDTO) {
		this.subjectDTO = subjectDTO;
	}
}
