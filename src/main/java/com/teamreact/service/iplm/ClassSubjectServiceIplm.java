package com.teamreact.service.iplm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teamreact.dao.ClassDao;
import com.teamreact.dao.ClassSubjectDAO;
import com.teamreact.dao.SubjectDao;
import com.teamreact.entity.Class;
import com.teamreact.entity.ClassSubject;
import com.teamreact.entity.Subject;
import com.teamreact.model.ClassDTO;
import com.teamreact.model.ClassSubjectDTO;
import com.teamreact.model.SubjectDTO;
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
		Subject subject = subjectDao.get(classSubjectDTO.getSubjectDTO().getId());
		Class classRoom = classDao.get(classSubjectDTO.getClassDTO().getId());
		
		classSubject.setClassRoom(classRoom);
		classSubject.setSubject(subject);
		
		classSubjectDAO.add(classSubject);
	}

	@Override
	public List<ClassSubjectDTO> findByClassId(long classId, int page, int limit) {
		List<ClassSubject> listClassSubjects = classSubjectDAO.findByClassid(classId, page, limit);
		List<ClassSubjectDTO> classSubjectDTOs = new ArrayList<ClassSubjectDTO>();
		
		
		for (ClassSubject classSubject : listClassSubjects) {
			classSubjectDTOs.add(convert(classSubject));
		}
		return classSubjectDTOs;
	}
	
	public ClassSubjectDTO convert(ClassSubject classSubject) {
		ClassSubjectDTO classSubjectDTO = new ClassSubjectDTO();
		
		Subject subject = subjectDao.get(classSubject.getSubject().getId());
		Class classRoom = classDao.get(classSubject.getClassRoom().getId());
		
		SubjectDTO subjectDTO = new SubjectDTO(subject.getId(), subject.getName());
		ClassDTO classDTO = new ClassDTO(classRoom.getId(), classRoom.getName());
		
		classSubjectDTO.setClassDTO(classDTO);
		classSubjectDTO.setSubjectDTO(subjectDTO);
		
		return classSubjectDTO;
	}

	@Override
	public Long countSearch(long classId, int page, int limit) {
		return classSubjectDAO.countFindByClassId(classId, page, limit);
	}

	@Override
	public Long countTotal() {
		return classSubjectDAO.countTotal();
	}

}
