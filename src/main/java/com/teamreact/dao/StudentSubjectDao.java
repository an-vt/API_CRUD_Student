package com.teamreact.dao;

import java.util.List;

import com.teamreact.entity.Result;
import com.teamreact.entity.StudentSubject;
import com.teamreact.entity.Subject;
import com.teamreact.model.SearchDTO;


public interface StudentSubjectDao {
	void add(StudentSubject studentSubject);

	void update(StudentSubject studentSubject);

	void delete(StudentSubject studentSubject);

	Subject get(int id);

	List<StudentSubject> getAll();
	
	Long countTotal(SearchDTO searchDTO);
}