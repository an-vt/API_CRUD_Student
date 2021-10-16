package com.teamreact.dao.iplm;

import java.util.List;

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

	@Override
	public List<ClassSubject> findByClassid(long classId, int page, int limit) {
		if(page < 1) return null ;
		String jql = " select cS from ClassSubject cS where cS.classRoom.id = :classId";
		return entityManager.createQuery(jql, ClassSubject.class).setParameter("classId", classId)
				.setFirstResult(page-1).setMaxResults(limit).getResultList();
	}

	@Override
	public Long countFindByClassId(long classId, int page, int limit) {
		if(page < 1) return null ;
		String jql = " select count(cs) from ClassSubject cs where cs.classRoom.id = :classId";
		return entityManager.createQuery(jql, Long.class).setParameter("classId", classId)
				.setFirstResult(page-1).setMaxResults(limit).getSingleResult();
	}

	@Override
	public Long countTotal() {
		String jql = " select count(cs) from ClassSubject cs";
		return entityManager.createQuery(jql, Long.class).getSingleResult();
	}
	
	
}
