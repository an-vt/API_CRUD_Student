package com.teamreact.dao;

import java.util.List;

import com.teamreact.entity.ClassSubject;;


public interface ClassSubjectDAO {
	void add(ClassSubject classSubject);

//	void update(ClassSubject classSubject);

//	void delete(ClassSubject classSubject);

//	ClassSubject get(int id);

	List<ClassSubject> findByClassid(long classId, int page, int limit);
//	
	Long countFindByClassId(long classId, int page, int limit);
//	
	Long countTotal();
}