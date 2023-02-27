package com.emms.wipro.iaf.eAssessment.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emms.wipro.iaf.eAssessment.entity.User;
import com.emms.wipro.iaf.eAssessment.forms.UserLoginForm;

@Repository
public class UserDao {
	
	
	private EntityManager entityManager;
	
	
	UserDao(EntityManager manager){
		this.entityManager = manager;
	}
	
	
	@Transactional
	public String registerUser(User user) {
		Session session = this.entityManager.unwrap(Session.class);
		session.save(user);
		return Integer.toString(user.getUserid());
	}


	@Transactional
	public int getLatestUserId() {
		Session session = this.entityManager.unwrap(Session.class);
		Query sql = session.createSQLQuery("select max(user_id) from users ");
		int max = (int) sql.uniqueResult();
		return max;
		
	}

	@SuppressWarnings("deprecation")
	@Transactional
	public User login(UserLoginForm loginForm) {
		Session session = this.entityManager.unwrap(Session.class);
		Query hql = session.createQuery(" from User u where u.user_id=:userid ");
		hql.setParameter("userid", loginForm.getUserId());
		List<User> user = (List<User>)hql.list();
//		hql.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		return user.get(0);
	}
	
}
