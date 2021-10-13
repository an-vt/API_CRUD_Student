package com.teamreact.service;

import java.util.List;

import com.teamreact.model.ClassDTO;
import com.teamreact.model.SearchDTO;
import com.teamreact.model.StudentDTO;

public interface ClassService {
	void add(ClassDTO classDTO);

	void update(ClassDTO classDTO);

	void delete(int id);

	ClassDTO get(int id);

	List<ClassDTO> search(SearchDTO searchDTO);
	
	long countSearch(SearchDTO searchDTO);
	
	long countTotal(SearchDTO searchDTO);
}
