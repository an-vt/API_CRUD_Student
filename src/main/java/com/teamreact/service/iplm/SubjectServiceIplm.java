package com.teamreact.service.iplm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teamreact.dao.SubjectDao;
import com.teamreact.entity.Subject;
import com.teamreact.model.SearchDTO;
import com.teamreact.model.SubjectDTO;
import com.teamreact.service.SubjectService;

@Service
@Transactional
public class SubjectServiceIplm implements SubjectService {
	
	@Autowired
	SubjectDao subjectDao;
	
	@Override
	public void add(SubjectDTO subjectDTO) {
		Subject subject=new Subject();
		subject.setName(subjectDTO.getName());
		
		subjectDao.add(subject);
		subjectDTO.setId(subject.getId());
	}

	@Override
	public void update(SubjectDTO subjectDTO) {
		Subject subject = subjectDao.get(subjectDTO.getId());
		if(subject != null) {
			subject.setId(subjectDTO.getId());
			subject.setName(subjectDTO.getName());
			
			subjectDao.update(subject);
		}
	}

	@Override
	public void delete(int id) {
		Subject subject = subjectDao.get(id);
		if(subject != null) {
			subjectDao.delete(subject);
		}	
	}

	@Override
	public SubjectDTO get(int id) {
		Subject subject = subjectDao.get(id);
		System.out.println(subject);
		return convert(subject);
	}

	@Override
	public List<SubjectDTO> search(SearchDTO searchDTO) {
		List<Subject> listSubjects = subjectDao.search(searchDTO);
		List<SubjectDTO> listSubjectDTOs = new ArrayList<SubjectDTO>();
		
		
		for (Subject subject : listSubjects) {
			listSubjectDTOs.add(convert(subject));
		}
		return listSubjectDTOs;
	}
	
	public SubjectDTO convert(Subject subject) {
		SubjectDTO subjectDTO=new SubjectDTO();
		subjectDTO.setId(subject.getId());
		subjectDTO.setName(subject.getName());
		return subjectDTO;
	}
	
	@Override
	public long countSearch(SearchDTO searchDTO) {
		long count= subjectDao.countSearch(searchDTO);
		return count;
	}


	@Override
	public long countTotal(SearchDTO searchDTO) {
		long count=subjectDao.countTotal(searchDTO);
		return count;
	}
}
