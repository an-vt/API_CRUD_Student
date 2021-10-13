package com.teamreact.dao;

import java.util.List;

import com.teamreact.entity.Result;
import com.teamreact.entity.Subject;
import com.teamreact.model.SearchDTO;


public interface SubjectDao {
	void add(Subject subject);

	void update(Subject subject);

	void delete(Subject subject);

	Subject get(int id);

	List<Subject> getAll();
	
	Long countTotal(SearchDTO searchDTO);
}