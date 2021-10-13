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

import com.teamreact.dao.ClassDao;
import com.teamreact.entity.Class;
import com.teamreact.entity.Student;
import com.teamreact.model.SearchDTO;

@Repository
@Transactional
public class ClassDaoIplm extends JPARepository<Class> implements ClassDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Class get(int id) {
		return entityManager.find(Class.class, id);
	}

	@Override
	public List<Class> search(SearchDTO searchDTO) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Class> criteriaQuery = criteriaBuilder.createQuery(Class.class);
		Root<Class> root = criteriaQuery.from(Class.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (searchDTO.getKeyword() != null) {
			System.out.println("vao th search");
			Predicate predicate = criteriaBuilder.like( criteriaBuilder.lower(root.get("name")),
					"%" + searchDTO.getKeyword().toLowerCase() + "%" );
			predicates.add(predicate);
		}

		criteriaQuery.where(predicates.toArray(new Predicate[] {}));

		TypedQuery<Class> typedQuery = entityManager.createQuery(criteriaQuery.select(root));
		if (searchDTO.getStart() != null) {
			System.out.println("truyen start length");
			typedQuery.setFirstResult((searchDTO.getStart()));
			typedQuery.setMaxResults(searchDTO.getLength());
		}
		return typedQuery.getResultList();
	}

	@Override
	public Long countSearch(SearchDTO searchDTO) {
//		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//		CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
//		Root<Class> root = criteriaQuery.from(Class.class);
//
//		// Constructing list of parameters
//		List<Predicate> predicates = new ArrayList<Predicate>();
//		if (searchDTO.getKeyword() != null) {
//			System.out.println("vao th count search");
//			Predicate predicate = builder.like(builder.lower(root.get("name")),
//					"%" + searchDTO.getKeyword().toLowerCase() + "%");
//			predicates.add(predicate);
//		}
//
//		criteriaQuery.where(predicates.toArray(new Predicate[] {}));
//		TypedQuery<Long> typedQuery = entityManager.createQuery(criteriaQuery.select(builder.count(root)));
//		if (searchDTO.getStart() != null) {
//			typedQuery.setFirstResult((searchDTO.getStart()));
//			typedQuery.setMaxResults(searchDTO.getLength());
//			System.out.println("LOG: start"+searchDTO.getStart()+" length:"+searchDTO.getLength());
//		}
//		return typedQuery.getSingleResult();
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Class> criteriaQuery = criteriaBuilder.createQuery(Class.class);
		Root<Class> root = criteriaQuery.from(Class.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (searchDTO.getKeyword() != null) {
			System.out.println("vao th search");
			Predicate predicate = criteriaBuilder.like( criteriaBuilder.lower(root.get("name")),
					"%" + searchDTO.getKeyword().toLowerCase() + "%" );
			predicates.add(predicate);
		}

		criteriaQuery.where(predicates.toArray(new Predicate[] {}));

		TypedQuery<Class> typedQuery = entityManager.createQuery(criteriaQuery.select(root));
		if (searchDTO.getStart() != null) {
			System.out.println("truyen start length");
			typedQuery.setFirstResult((searchDTO.getStart()));
			typedQuery.setMaxResults(searchDTO.getLength());
		}
		return (long) typedQuery.getResultList().size();
	}

	@Override
	public Long countTotal(SearchDTO searchDTO) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		Root<Class> root = criteriaQuery.from(Class.class);

		TypedQuery<Long> typedQuery = entityManager.createQuery(criteriaQuery.select(criteriaBuilder.count(root)));
		return typedQuery.getSingleResult();
	}

}
