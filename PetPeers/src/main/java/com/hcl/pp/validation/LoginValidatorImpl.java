package com.hcl.pp.validation;

import org.springframework.stereotype.Service;

import com.hcl.pp.appexception.ApplicationException;
import com.hcl.pp.model.User;

@Service("loginValidatorImpl")
public class LoginValidatorImpl implements LoginValidator{

	@Override
	public boolean validateUserLogin(User user) throws ApplicationException {
	    
		if(user.getUserName()==""||user.getPassword()=="")
		{
			throw new ApplicationException("All fields are mandatory");
		}
		else if(user.getUserName().length()<6 || user.getUserName().length()>25)
		{
			throw new ApplicationException("Username length should be in between 6-25");
		}
		else
		{
			return true;
		}	
	}

}
