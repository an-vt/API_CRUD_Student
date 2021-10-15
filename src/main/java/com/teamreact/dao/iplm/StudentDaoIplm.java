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

import com.teamreact.dao.StudentDao;
import com.teamreact.entity.Student;

@Repository // lam viec voi csdl
@Transactional // quan ly giao dich.
public class StudentDaoIplm extends JPARepository<Student> implements StudentDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Student get(long id) {
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> search(String search, int page, int limit) {
		if(page < 0) page = 0;
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
		Root<Student> root = criteriaQuery.from(Student.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (search != null) {
			Predicate predicate = criteriaBuilder.like( criteriaBuilder.lower(root.get("name")),
					"%" + search + "%" );
			predicates.add(predicate);
		}

		criteriaQuery.where(predicates.toArray(new Predicate[] {}));

		TypedQuery<Student> typedQuery = entityManager.createQuery(criteriaQuery.select(root));
		typedQuery.setFirstResult(page - 1);
		typedQuery.setMaxResults(limit);
		return typedQuery.getResultList();
	}

	@Override
	public Long countSearch(String search, int page, int limit) {
		if(page < 0) page = 0;
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
		Root<Student> root = criteriaQuery.from(Student.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (search != null) {
			Predicate predicate = criteriaBuilder.like( criteriaBuilder.lower(root.get("name")),
					"%" + search + "%" );
			predicates.add(predicate);
		}

		criteriaQuery.where(predicates.toArray(new Predicate[] {}));

		TypedQuery<Student> typedQuery = entityManager.createQuery(criteriaQuery.select(root));
		typedQuery.setFirstResult(page - 1);
		typedQuery.setMaxResults(limit);
		return (long) typedQuery.getResultList().size();
	}

	@Override
	public Long countTotal() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		Root<Student> root = criteriaQuery.from(Student.class);

		TypedQuery<Long> typedQuery = entityManager.createQuery(criteriaQuery.select(criteriaBuilder.count(root)));
		return typedQuery.getSingleResult();
	}

}
