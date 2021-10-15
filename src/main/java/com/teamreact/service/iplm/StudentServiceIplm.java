package com.teamreact.service.iplm;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teamreact.dao.ClassDao;
import com.teamreact.dao.StudentDao;
import com.teamreact.entity.Class;
import com.teamreact.entity.Student;
import com.teamreact.model.ClassDTO;
import com.teamreact.model.StudentDTO;
import com.teamreact.service.StudentService;
import com.teamreact.untils.DateTimeUtils;

@Service
@Transactional
public class StudentServiceIplm implements StudentService {
	
	@Autowired
	StudentDao studentDao;
	
	@Autowired
	ClassDao classDao;
	
	@Override
	public void add(StudentDTO studentDTO) {
		Student student=new Student();
		
		student.setAge(studentDTO.getAge());
		student.setName(studentDTO.getName());
		student.setAddress(studentDTO.getAddress());
		System.out.println("date "+studentDTO.getdOB());
		student.setdOB(Date.valueOf(studentDTO.getdOB()));
		student.setGender(studentDTO.getGender());
		
		Class classRoom = classDao.get(studentDTO.getClassDTO().getId());	
		student.setClassRoom(classRoom);
		
		studentDao.add(student);
		studentDTO.setId(student.getId());                     
	}

	@Override
	public void update(StudentDTO studentDTO) {
		Student student = studentDao.get(studentDTO.getId());
		
		if(student != null) {
			System.out.println("update");
			student.setAge(studentDTO.getAge());
			student.setName(studentDTO.getName());
			student.setAddress(studentDTO.getAddress());
			student.setdOB(Date.valueOf(studentDTO.getdOB()));
			student.setGender(studentDTO.getGender());
			
			Class classRoom = classDao.get(studentDTO.getClassDTO().getId());	
			student.setClassRoom(classRoom);
			
			studentDao.update(student);
		}
	}

	@Override
	public void delete(long id) {
		Student Student = studentDao.get(id);
		if(Student != null) {
			studentDao.delete(Student);
		}	
	}

	@Override
	public StudentDTO get(long id) {
		Student Student = studentDao.get(id);
		return convert(Student);
	}

	@Override
	public List<StudentDTO> search(String search, int page, int limit) {
		List<Student> listStudents = studentDao.search(search , page, limit);
		List<StudentDTO> listStudentDTOs = new ArrayList<StudentDTO>();
		
		for (Student Student : listStudents) {
			listStudentDTOs.add(convert(Student));
		}
		return listStudentDTOs;
	}
	
	@Override
	public long countSearch(String search, int page, int limit) {
		long count= studentDao.countSearch(search, page, limit);
		return count;
	}


	@Override
	public long countTotal() {
		long count=studentDao.countTotal();
		return count;
	}
	
	public StudentDTO convert(Student student) {
		StudentDTO studentDTO=new StudentDTO();
		
		studentDTO.setId(student.getId());
		studentDTO.setName(student.getName());
		studentDTO.setAge(student.getAge());
		studentDTO.setAddress(student.getAddress());
		studentDTO.setdOB(student.toString());
		studentDTO.setGender(student.getGender());
		
		Class classRoom = classDao.get(student.getClassRoom().getId());
		ClassDTO classDTO = new ClassDTO(classRoom.getId(), classRoom.getName());
		
		studentDTO.setClassDTO(classDTO);
		
		return studentDTO;
	}
}
