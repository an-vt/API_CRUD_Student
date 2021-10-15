package com.teamreact.service;

import java.util.List;

import com.teamreact.model.StudentDTO;

public interface StudentService {
	void add(StudentDTO studentDTO);

	void update(StudentDTO studentDTO);

	void delete(long id);

	StudentDTO get(long id);

	List<StudentDTO> search(String search, int page, int limit);
	
	long countSearch(String search, int page, int limit);
	
	long countTotal();
}
