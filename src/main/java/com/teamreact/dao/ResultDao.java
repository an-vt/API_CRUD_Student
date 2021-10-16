package com.teamreact.dao;

import java.util.List;

import com.teamreact.entity.Result;


public interface ResultDao {
	void add(Result result);
	
	List<Result> findByStudentId(long studentId, int page, int limit);
	
	long countFindByStudentId(long studentId, int page, int limit);
	
//	void update(Result result);
//
//	void delete(Result result);
//
//	Result get(int id);

//	List<Result> search(String search, int page, int limit);
//	
//	Long countTotal(String search, int page, int limit);
//	
	Long countTotal();
}