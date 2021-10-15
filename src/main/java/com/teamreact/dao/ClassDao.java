package com.teamreact.dao;

import java.util.List;

import com.teamreact.entity.Class;


public interface ClassDao {
	void add(Class classroom);

	void update(Class classroom);

	void delete(Class classroom);

	Class get(long id);

	List<Class> search(String search, int page, int limit);
	
	Long countSearch(String search, int page, int limit);
	
	Long countTotal();
}