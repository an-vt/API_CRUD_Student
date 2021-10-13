package com.teamreact.service;

import java.util.List;

import com.teamreact.model.SearchDTO;
import com.teamreact.model.StudentDTO;

public interface StudentService {
	void add(StudentDTO studentDTO);

	void update(StudentDTO studentDTO);

	void delete(int id);

	StudentDTO get(int id);

	List<StudentDTO> search(SearchDTO searchDTO);
	
	long countSearch(SearchDTO searchDTO);
	
	long countTotal(SearchDTO searchDTO);
}
