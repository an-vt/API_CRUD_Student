package com.teamreact.service;

import java.util.List;

import com.teamreact.model.ResultDTO;

public interface ResultService {
	void add(ResultDTO resultDTO);

//	void update(ClassSubjectDTO classDTO);
//
//	void delete(int id);

//	ClassSubjectDTO get(int id);

	List<ResultDTO> findByStudentId(long studentId, int page, int limit);
//	
	Long countFindByStudentId(long studentId, int page, int limit);
	
	Long countTotal();
}
