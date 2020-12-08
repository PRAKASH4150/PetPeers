package com.hcl.pp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.pp.appexception.ApplicationException;
import com.hcl.pp.dao.LoginDao;
import com.hcl.pp.model.User;

@Service("loginServiceImpl")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDaoImpl;
	
	@Override
	@Transactional
	public User validateUser(User user) throws ApplicationException {
	
		return loginDaoImpl.validateUser(user);
	}
}
