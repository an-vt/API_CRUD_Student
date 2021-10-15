package com.teamreact.service;

import java.util.List;

import com.teamreact.model.ClassDTO;

public interface ClassService {
	void add(ClassDTO classDTO);

	void update(ClassDTO classDTO);

	void delete(long id);

	ClassDTO get(long id);

	List<ClassDTO> search(String search, int page, int limit);
	
	long countSearch(String search, int page, int limit);
	
	long countTotal();
}
