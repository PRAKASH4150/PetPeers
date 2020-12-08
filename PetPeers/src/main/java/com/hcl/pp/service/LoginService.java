package com.hcl.pp.service;

import com.hcl.pp.appexception.ApplicationException;
import com.hcl.pp.model.User;

public interface LoginService {

	public User validateUser(User user) throws ApplicationException;
}
