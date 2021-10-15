package com.teamreact.service.iplm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teamreact.dao.ResultDao;
import com.teamreact.dao.StudentDao;
import com.teamreact.dao.SubjectDao;
import com.teamreact.entity.Result;
import com.teamreact.entity.Student;
import com.teamreact.entity.Subject;
import com.teamreact.model.ResultDTO;
import com.teamreact.service.ResultService;

@Service
@Transactional
public class ResultServiceIplm implements ResultService {
	
	@Autowired
	ResultDao resultDao;
	
	@Autowired
	SubjectDao subjectDao;
	
	@Autowired
	StudentDao studentDao;
	
	@Override
	public void add(ResultDTO resultDTO) {
		Result result = new Result();
		Subject subject = subjectDao.get(resultDTO.getSubjectId());
		Student student = studentDao.get(resultDTO.getStudentId());
		
		result.setStudent(student);
		result.setSubject(subject);
		result.setPoint(resultDTO.getPoint());
		
		resultDao.add(result);
	}

}
