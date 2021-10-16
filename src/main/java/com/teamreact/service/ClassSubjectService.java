package com.teamreact.service;

import java.util.List;

import com.teamreact.model.ClassSubjectDTO;

public interface ClassSubjectService {
	void add(ClassSubjectDTO classSubjectDTO);

	List<ClassSubjectDTO> findByClassId(long classId, int page, int limit);

	Long countSearch(long classId, int page, int limit);
	
	Long countTotal();
}
