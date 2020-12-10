package com.hcl.pp.validation;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.hcl.pp.appexception.ApplicationException;
import com.hcl.pp.model.User;
/**
 * 
 * @author LakamsaniHanumanSai(51897508)
 *
 */

@Service("loginValidatorImpl")
public class LoginValidatorImpl implements LoginValidator{

	private static final Logger logger=LogManager.getLogger(LogManager.class);
	
	@Override
	public boolean validateUserLogin(User user) throws ApplicationException {
	    
		if(user.getUserName()==""||user.getPassword()=="")
		{
			logger.info("User didnot entered all the details");
			throw new ApplicationException("All fields are mandatory");
		}
		else if(user.getUserName().length()<6 || user.getUserName().length()>25)
		{
			logger.info("Username length should be in between 6-25");
			throw new ApplicationException("Username length should be in between 6-25");
		}
		else
		{
			return true;
		}	
	}

}
