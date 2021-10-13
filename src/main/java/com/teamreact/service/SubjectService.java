package com.teamreact.service;

import java.util.List;

import com.teamreact.model.ClassDTO;
import com.teamreact.model.SearchDTO;
import com.teamreact.model.StudentDTO;
import com.teamreact.model.SubjectDTO;

public interface SubjectService {
	void add(SubjectDTO subjectDTO);

	void update(SubjectDTO subjectDTO);

	void delete(int id);

	SubjectDTO get(int id);

	List<SubjectDTO> search(SearchDTO searchDTO);
	
	long countSearch(SearchDTO searchDTO);
	
	long countTotal(SearchDTO searchDTO);
}
