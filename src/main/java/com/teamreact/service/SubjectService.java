package com.teamreact.service;

import java.util.List;

import com.teamreact.model.SubjectDTO;

public interface SubjectService {
	void add(SubjectDTO subjectDTO);

	void update(SubjectDTO subjectDTO);

	void delete(long id);

	SubjectDTO get(long id);

	List<SubjectDTO> search(String search, int page, int limit);
	
	long countSearch(String search, int page, int limit);
	
	long countTotal();
}
