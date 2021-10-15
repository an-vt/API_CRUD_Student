package com.teamreact.dao;

import java.util.List;

import com.teamreact.entity.Student;


public interface StudentDao {
	void add(Student student);

	void update(Student student);

	void delete(Student student);

	Student get(long id);

	List<Student> search(String search, int page, int limit);
	
	Long countSearch(String search, int page, int limit);
	
	Long countTotal();
}