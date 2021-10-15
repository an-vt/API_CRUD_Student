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

import com.teamreact.dao.SubjectDao;
import com.teamreact.entity.Subject;

@Repository 
@Transactional
public class SubjectDaoIplm extends JPARepository<Subject> implements SubjectDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Subject get(long id) {
		return entityManager.find(Subject.class, id);
	}

	@Override
	public List<Subject> search(String search, int page, int limit) {
		if(page < 0) page = 0;
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Subject> criteriaQuery = criteriaBuilder.createQuery(Subject.class);
		Root<Subject> root = criteriaQuery.from(Subject.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (search != null) {
			Predicate predicate = criteriaBuilder.like( criteriaBuilder.lower(root.get("name")),
					"%" + search + "%" );
			predicates.add(predicate);
		}

		criteriaQuery.where(predicates.toArray(new Predicate[] {}));

		TypedQuery<Subject> typedQuery = entityManager.createQuery(criteriaQuery.select(root));
		typedQuery.setFirstResult(page - 1);
		typedQuery.setMaxResults(limit);
		return typedQuery.getResultList();
	}

	@Override
	public Long countSearch(String search, int page, int limit) {
		if(page < 0) page = 0;
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Subject> criteriaQuery = criteriaBuilder.createQuery(Subject.class);
		Root<Subject> root = criteriaQuery.from(Subject.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (search != null) {
			Predicate predicate = criteriaBuilder.like( criteriaBuilder.lower(root.get("name")),
					"%" + search + "%" );
			predicates.add(predicate);
		}

		criteriaQuery.where(predicates.toArray(new Predicate[] {}));

		TypedQuery<Subject> typedQuery = entityManager.createQuery(criteriaQuery.select(root));
		typedQuery.setFirstResult(page - 1);
		typedQuery.setMaxResults(limit);
		return (long) typedQuery.getResultList().size();
	}

	@Override
	public Long countTotal() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		Root<Subject> root = criteriaQuery.from(Subject.class);

		TypedQuery<Long> typedQuery = entityManager.createQuery(criteriaQuery.select(criteriaBuilder.count(root)));
		return typedQuery.getSingleResult();
	}

}
