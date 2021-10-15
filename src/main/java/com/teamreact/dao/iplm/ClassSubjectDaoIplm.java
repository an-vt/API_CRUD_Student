package com.teamreact.dao.iplm;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.teamreact.dao.ClassSubjectDAO;
import com.teamreact.entity.ClassSubject;

@Repository 
@Transactional
public class ClassSubjectDaoIplm extends JPARepository<ClassSubject> implements ClassSubjectDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

//	@Override
//	public ClassSubject get(int id) {
//		return entityManager.find(ClassSubject.class, id);
//	}
}
