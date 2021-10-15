package com.teamreact.dao.iplm;

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

//	@Override
//	public Result get(int id) {
//		return entityManager.find(Result.class, id);
//	}
}
