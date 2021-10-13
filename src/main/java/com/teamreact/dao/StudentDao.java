package com.teamreact.dao;

import java.util.List;

import com.teamreact.entity.Student;
import com.teamreact.model.SearchDTO;


public interface StudentDao {
	void add(Student student);

	void update(Student student);

	void delete(Student student);

	Student get(int id);

	List<Student> search(SearchDTO searchDTO);
	
	Long countSearch(SearchDTO searchDTO);
	
	Long countTotal(SearchDTO searchDTO);
}