package com.teamreact.service.iplm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teamreact.dao.ClassDao;
import com.teamreact.dao.ClassSubjectDAO;
import com.teamreact.dao.SubjectDao;
import com.teamreact.entity.Class;
import com.teamreact.entity.ClassSubject;
import com.teamreact.entity.Subject;
import com.teamreact.model.ClassSubjectDTO;
import com.teamreact.service.ClassSubjectService;

@Service
@Transactional
public class ClassSubjectServiceIplm implements ClassSubjectService {
	
	@Autowired
	ClassSubjectDAO classSubjectDAO;
	
	@Autowired
	SubjectDao subjectDao;
	
	@Autowired
	ClassDao classDao;
	
	@Override
	public void add(ClassSubjectDTO classSubjectDTO) {
		ClassSubject classSubject = new ClassSubject();
		Subject subject = subjectDao.get(classSubjectDTO.getSubjectId());
		Class classRoom = classDao.get(classSubjectDTO.getClassId());
		
		classSubject.setClassRoom(classRoom);
		classSubject.setSubject(subject);
		
		classSubjectDAO.add(classSubject);
	}

}
