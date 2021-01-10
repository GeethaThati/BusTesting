package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GenericDao {

	public Object save(Object obj) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("busTest");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		Object updatedObject = em.merge(obj);
		tx.commit();

		emf.close();
		em.close();
		return updatedObject;

	}

	public Object fetch(Class cls, Object pk) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("busTest");
		EntityManager em = emf.createEntityManager();

		Object obj = em.find(cls, pk);

		emf.close();
		em.close();
		return obj;
	}

}
