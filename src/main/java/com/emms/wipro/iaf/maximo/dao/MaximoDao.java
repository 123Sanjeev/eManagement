package com.emms.wipro.iaf.maximo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class MaximoDao {

	@PersistenceContext(unitName="maximoPersistenceUnit")
	private EntityManager maximoEntityManager;
	
	@Transactional
	public String moodleUser(String user) {
		Query query = maximoEntityManager.createNativeQuery("Select firstname from mdl_user where id=:user ");
		query.setParameter("user", user);
		String response =(String) query.getResultList().get(0);
		return response;
	}
	
}
