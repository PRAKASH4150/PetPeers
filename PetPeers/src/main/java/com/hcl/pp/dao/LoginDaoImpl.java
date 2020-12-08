package com.hcl.pp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.pp.appexception.ApplicationException;
import com.hcl.pp.model.User;

@Repository("loginDaoImpl")
public class LoginDaoImpl implements LoginDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User validateUser(User user) throws ApplicationException {

		Long user_id;
		String sql = "SELECT userId  FROM User user WHERE user.userName=:username AND user.password=:password";

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(sql);
		query.setString("username", user.getUserName());
		query.setString("password", user.getPassword());
		user_id = (Long) query.uniqueResult();
		if (user_id ==null) {
			throw new ApplicationException("Either User Name or Password or both are invalid");
		}
		else
		{
			user.setUserId(user_id);
		}
		return user;
	}

}
