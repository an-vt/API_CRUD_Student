package com.teamreact.service.iplm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teamreact.dao.ClassDao;
import com.teamreact.dao.ResultDao;
import com.teamreact.dao.StudentDao;
import com.teamreact.dao.SubjectDao;
import com.teamreact.entity.Class;
import com.teamreact.entity.Result;
import com.teamreact.entity.Student;
import com.teamreact.entity.Subject;
import com.teamreact.model.ClassDTO;
import com.teamreact.model.ResultDTO;
import com.teamreact.model.StudentDTO;
import com.teamreact.model.SubjectDTO;
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
	
	@Autowired
	ClassDao classDao;
	
	@Override
	public void add(ResultDTO resultDTO) {
		Result result = new Result();
		Student student = studentDao.get(resultDTO.getStudentDTO().getId());
		Subject subject = subjectDao.get(resultDTO.getSubjectDTO().getId());
		
		result.setStudent(student);
		result.setSubject(subject);
		result.setPoint(resultDTO.getPoint());
		
		resultDao.add(result);
	}

	@Override
	public List<ResultDTO> findByStudentId(long studentId, int page, int limit) {
		List<Result> listResults = resultDao.findByStudentId(studentId, page, limit);
		List<ResultDTO> resultDTOs = new ArrayList<ResultDTO>();
		
		
		for (Result result : listResults) {
			resultDTOs.add(convert(result));
		}
		return resultDTOs;
	}
	
	public ResultDTO convert(Result result) {
		ResultDTO resultDTO = new ResultDTO();
		
		Subject subject = subjectDao.get(result.getSubject().getId());
		Student student = studentDao.get(result.getStudent().getId());
		Class classRoom = classDao.get(student.getClassRoom().getId());
		
		SubjectDTO subjectDTO = new SubjectDTO(subject.getId(), subject.getName());
		ClassDTO classDTO = new ClassDTO(classRoom.getId(), classRoom.getName());
		
		StudentDTO studentDTO = new StudentDTO(student.getId(), student.getName(), student.getAge()
				,student.getAddress() , student.getGender(), student.getdOB().toString(), classDTO);
		resultDTO.setStudentDTO(studentDTO);
		resultDTO.setSubjectDTO(subjectDTO);
		resultDTO.setPoint(result.getPoint());
		return resultDTO;
	}

	@Override
	public Long countFindByStudentId(long studentId, int page, int limit) {
		return resultDao.countFindByStudentId(studentId, page, limit);
	}

	@Override
	public Long countTotal() {
		return resultDao.countTotal();
	}

}
