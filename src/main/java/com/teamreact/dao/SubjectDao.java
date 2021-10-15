package com.teamreact.dao;

import java.util.List;

import com.teamreact.entity.Subject;


public interface SubjectDao {
	void add(Subject subject);

	void update(Subject subject);

	void delete(Subject subject);

	Subject get(long id);

	List<Subject> search(String search, int page, int limit);
	
	Long countSearch(String search, int page, int limit);
	
	Long countTotal();
}