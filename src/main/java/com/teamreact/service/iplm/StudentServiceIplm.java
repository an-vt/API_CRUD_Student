package com.teamreact.service.iplm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teamreact.dao.ClassDao;
import com.teamreact.dao.StudentDao;
import com.teamreact.entity.Student;
import com.teamreact.entity.Class;
import com.teamreact.model.ClassDTO;
import com.teamreact.model.SearchDTO;
import com.teamreact.model.StudentDTO;
import com.teamreact.service.StudentService;

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
		
		Class classRoom = new Class();
		classRoom.setId(studentDTO.getClassDTO().getId());
		student.setClassRoom(classRoom);
		
		studentDao.add(student);
		studentDTO.setId(student.getId());
	}

	@Override
	public void update(StudentDTO studentDTO) {
		Student student = studentDao.get(studentDTO.getId());
		if(student != null) {
			student.setId(studentDTO.getId());
			student.setName(studentDTO.getName());
			Class classRoom = new Class();
			System.out.println(studentDTO.getClassDTO());
			classRoom.setId(studentDTO.getClassDTO().getId());
			student.setClassRoom(classRoom);
			student.setAge(studentDTO.getAge());
			
			studentDao.update(student);
		}
	}

	@Override
	public void delete(int id) {
		Student Student = studentDao.get(id);
		if(Student != null) {
			studentDao.delete(Student);
		}	
	}

	@Override
	public StudentDTO get(int id) {
		Student Student = studentDao.get(id);
		System.out.println(Student);
		return convert(Student);
	}

	@Override
	public List<StudentDTO> search(SearchDTO searchDTO) {
		System.out.println(searchDTO.getKeyword());
		List<Student> listStudents = studentDao.search(searchDTO);
		List<StudentDTO> listStudentDTOs = new ArrayList<StudentDTO>();
		
		for (Student Student : listStudents) {
			listStudentDTOs.add(convert(Student));
		}
		return listStudentDTOs;
	}
	
	public StudentDTO convert(Student student) {
		StudentDTO studentDTO=new StudentDTO();
		
		studentDTO.setId(student.getId());
		studentDTO.setName(student.getName());
		studentDTO.setAge(student.getAge());
		
		ClassDTO classDTO = new ClassDTO();
		classDTO.setId(student.getClassRoom().getId());
		studentDTO.setClassDTO(classDTO);
		
		studentDTO.setClassDTO(classDTO);
		return studentDTO;
	}
	
	@Override
	public long countSearch(SearchDTO searchDTO) {
		long count= studentDao.countSearch(searchDTO);
		return count;
	}


	@Override
	public long countTotal(SearchDTO searchDTO) {
		long count=studentDao.countTotal(searchDTO);
		return count;
	}
}
