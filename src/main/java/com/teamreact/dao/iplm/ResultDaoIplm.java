package com.teamreact.dao.iplm;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.teamreact.dao.ResultDao;
import com.teamreact.entity.Result;

@Repository 
@Transactional
public class ResultDaoIplm extends JPARepository<Result> implements ResultDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Result> findByStudentId(long studentId, int page, int limit) {
		if(page < 1) return null ;
		String jql = " select r from Result r where r.student.id = :studentId";
		return entityManager.createQuery(jql, Result.class).setParameter("studentId", studentId).setFirstResult(page-1).setMaxResults(limit).getResultList();
	}

	@Override
	public long countFindByStudentId(long studentId, int page, int limit) {
		if(page < 1) return 0;
		String jql = " select count(r) from Result r where r.student.id = :studentId";
		return entityManager.createQuery(jql, Long.class).setParameter("studentId", studentId).setFirstResult(page-1).setMaxResults(limit).getSingleResult();
	}

	@Override
	public Long countTotal() {
		String jql = " select count(r) from Result r";
		return entityManager.createQuery(jql, Long.class).getSingleResult();
	}
	
}
