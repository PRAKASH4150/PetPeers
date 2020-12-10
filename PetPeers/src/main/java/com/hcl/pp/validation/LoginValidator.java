package com.hcl.pp.validation;

import com.hcl.pp.appexception.ApplicationException;
import com.hcl.pp.model.User;
/**
 * 
 * @author LakamsaniHanumanSai(51897508)
 *
 */

public interface LoginValidator {
 
	 public boolean validateUserLogin(User user) throws ApplicationException;
}
