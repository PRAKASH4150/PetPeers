package com.hcl.pp.service;

import com.hcl.pp.appexception.ApplicationException;
import com.hcl.pp.model.User;
/**
 * 
 * @author LakamsaniHanumanSai(51897508)
 *
 */

public interface LoginService {

	public User validateUser(User user) throws ApplicationException;
}
