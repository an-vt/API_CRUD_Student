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

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.teamreact.dao.SubjectDao;
import com.teamreact.entity.Subject;
import com.teamreact.model.SearchDTO;

@Repository 
@Transactional
public class SubjectDaoIplm extends JPARepository<Subject> implements SubjectDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Subject get(int id) {
		return entityManager.find(Subject.class, id);
	}

	@Override
	public List<Subject> search(SearchDTO searchDTO) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Subject> criteriaQuery = criteriaBuilder.createQuery(Subject.class);
		Root<Subject> root = criteriaQuery.from(Subject.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (StringUtils.isNotBlank(searchDTO.getKeyword())) {
			Predicate predicate = criteriaBuilder.like( criteriaBuilder.lower(root.get("name")),
					"%" + searchDTO.getKeyword().toLowerCase() + "%" );
			predicates.add(predicate);
		}

		criteriaQuery.where(predicates.toArray(new Predicate[] {}));

		TypedQuery<Subject> typedQuery = entityManager.createQuery(criteriaQuery.select(root));
		if (searchDTO.getStart() != null) {
			System.out.println("truyen start length");
			typedQuery.setFirstResult((searchDTO.getStart()));
			typedQuery.setMaxResults(searchDTO.getLength());
		}
		return typedQuery.getResultList();
	}

	@Override
	public Long countSearch(SearchDTO searchDTO) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
		Root<Subject> root = criteriaQuery.from(Subject.class);

		// Constructing list of parameters
		List<Predicate> predicates = new ArrayList<Predicate>();
		if (StringUtils.isNotBlank(searchDTO.getKeyword())) {
			Predicate predicate = builder.like(builder.lower(root.get("name")),
					"%" + searchDTO.getKeyword().toLowerCase() + "%");
			predicates.add(predicate);
		}

		criteriaQuery.where(predicates.toArray(new Predicate[] {}));
		TypedQuery<Long> typedQuery = entityManager.createQuery(criteriaQuery.select(builder.count(root)));
		return typedQuery.getSingleResult();
	}

	@Override
	public Long countTotal(SearchDTO searchDTO) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		Root<Subject> root = criteriaQuery.from(Subject.class);

		TypedQuery<Long> typedQuery = entityManager.createQuery(criteriaQuery.select(criteriaBuilder.count(root)));
		return typedQuery.getSingleResult();
	}

}
