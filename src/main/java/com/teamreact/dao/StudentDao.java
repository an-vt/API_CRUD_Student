package com.teamreact.dao;

import java.util.List;

import com.teamreact.entity.Result;
import com.teamreact.model.SearchDTO;


public interface StudentDao {
	void add(Result result);

	void update(Result result);

	void delete(Result result);

	Result get(int id);

	List<Result> getAll();
	
	Long countTotal(SearchDTO searchDTO);
}