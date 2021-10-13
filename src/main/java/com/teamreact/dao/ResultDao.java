package com.teamreact.dao;

import java.util.List;

import com.teamreact.entity.Class;
import com.teamreact.entity.Student;
import com.teamreact.model.SearchDTO;


public interface ResultDao {
	void add(Class classroom);

	void update(Class classroom);

	void delete(Class classroom);

	Student get(int id);

	List<Class> getAll();
	
	Long countTotal(SearchDTO searchDTO);
}