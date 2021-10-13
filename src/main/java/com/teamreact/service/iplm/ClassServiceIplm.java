package com.teamreact.service.iplm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teamreact.dao.ClassDao;
import com.teamreact.entity.Class;
import com.teamreact.model.SearchDTO;
import com.teamreact.service.ClassService;
import com.teamreact.model.ClassDTO;

@Service
@Transactional
public class ClassServiceIplm implements ClassService {
	
	@Autowired
	ClassDao classDao;
	
	@Override
	public void add(ClassDTO classDTO) {
		Class classRoom=new Class();
		classRoom.setName(classDTO.getName());
		
		classDao.add(classRoom);
		classDTO.setId(classRoom.getId());
	}

	@Override
	public void update(ClassDTO ClassDTO) {
		Class classRoom = classDao.get(ClassDTO.getId());
		if(classRoom != null) {
			classRoom.setId(ClassDTO.getId());
			classRoom.setName(ClassDTO.getName());
			
			classDao.update(classRoom);
		}
	}

	@Override
	public void delete(int id) {
		Class classRoom = classDao.get(id);
		if(classRoom != null) {
			classDao.delete(classRoom);
		}	
	}

	@Override
	public ClassDTO get(int id) {
		Class classRoom = classDao.get(id);
		System.out.println(classRoom);
		return convert(classRoom);
	}

	@Override
	public List<ClassDTO> search(SearchDTO searchDTO) {
		List<Class> listClasss = classDao.search(searchDTO);
		List<ClassDTO> listClassDTOs = new ArrayList<ClassDTO>();
		
		
		for (Class classRoom : listClasss) {
			listClassDTOs.add(convert(classRoom));
		}
		return listClassDTOs;
	}
	
	public ClassDTO convert(Class classRoom) {
		ClassDTO classDTO=new ClassDTO();
		classDTO.setId(classRoom.getId());
		classDTO.setName(classRoom.getName());
		return classDTO;
	}
	
	@Override
	public long countSearch(SearchDTO searchDTO) {
		long count= classDao.countSearch(searchDTO);
		return count;
	}


	@Override
	public long countTotal(SearchDTO searchDTO) {
		long count=classDao.countTotal(searchDTO);
		return count;
	}
}
