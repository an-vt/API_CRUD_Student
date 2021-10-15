package com.teamreact.service.iplm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teamreact.dao.ClassDao;
import com.teamreact.entity.Class;
import com.teamreact.model.ClassDTO;
import com.teamreact.service.ClassService;

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
	public void update(ClassDTO classDTO) {
		Class classRoom = classDao.get(classDTO.getId());
		if(classRoom != null) {
			classRoom.setId(classDTO.getId());
			classRoom.setName(classDTO.getName());
			
			classDao.update(classRoom);
		}
	}

	@Override
	public void delete(long id) {
		Class classRoom = classDao.get(id);
		if(classRoom != null) {
			classDao.delete(classRoom);
		}	
	}

	@Override
	public ClassDTO get(long id) {
		Class classRoom = classDao.get(id);
		System.out.println(classRoom);
		return convert(classRoom);
	}

	@Override
	public List<ClassDTO> search(String search, int page, int limit) {
		List<Class> listClasss = classDao.search(search, page, limit);
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
	public long countSearch(String search, int page, int limit) {
		long count= classDao.countSearch(search, page, limit);
		return count;
	}


	@Override
	public long countTotal() {
		long count=classDao.countTotal();
		return count;
	}
}
