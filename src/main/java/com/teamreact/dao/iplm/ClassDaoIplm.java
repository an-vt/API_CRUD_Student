package com.teamreact.dao.iplm;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.teamreact.dao.ClassDao;
import com.teamreact.entity.Class;

@Repository
@Transactional
public class ClassDaoIplm extends JPARepository<Class> implements ClassDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Class get(long id) {
		return entityManager.find(Class.class, id);
	}

	@Override
	public List<Class> search(String search, int page, int limit) {
		if(page < 0) page = 0;
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Class> criteriaQuery = criteriaBuilder.createQuery(Class.class);
		Root<Class> root = criteriaQuery.from(Class.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (search != null) {
			System.out.println("vao th search");
			Predicate predicate = criteriaBuilder.like( criteriaBuilder.lower(root.get("name")),
					"%" + search + "%" );
			predicates.add(predicate);
		}

		criteriaQuery.where(predicates.toArray(new Predicate[] {}));

		TypedQuery<Class> typedQuery = entityManager.createQuery(criteriaQuery.select(root));
		typedQuery.setFirstResult(page-1);
		typedQuery.setMaxResults(limit);
		return typedQuery.getResultList();
	}

	@Override
	public Long countSearch(String search, int page, int limit) {
		if(page < 0) page = 0;
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Class> criteriaQuery = criteriaBuilder.createQuery(Class.class);
		Root<Class> root = criteriaQuery.from(Class.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (search != null) {
			System.out.println("vao th search");
			Predicate predicate = criteriaBuilder.like( criteriaBuilder.lower(root.get("name")),
					"%" + search + "%" );
			predicates.add(predicate);
		}

		criteriaQuery.where(predicates.toArray(new Predicate[] {}));

		TypedQuery<Class> typedQuery = entityManager.createQuery(criteriaQuery.select(root));
		typedQuery.setFirstResult(page-1);
		typedQuery.setMaxResults(limit);
		return (long) typedQuery.getResultList().size();
	}

	@Override
	public Long countTotal() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		Root<Class> root = criteriaQuery.from(Class.class);

		TypedQuery<Long> typedQuery = entityManager.createQuery(criteriaQuery.select(criteriaBuilder.count(root)));
		return typedQuery.getSingleResult();
	}

}
