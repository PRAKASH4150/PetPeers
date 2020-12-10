package com.hcl.pp.validation;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.hcl.pp.appexception.ApplicationException;
import com.hcl.pp.model.User;
/**
 * 
 * @author MokaSaiSuryaPrakash(51897451)
 *
 */

@Service("securityServiceImpl")
public class SecurityServiceImpl implements SecurityService{
	
	private static final Logger logger=LogManager.getLogger(LogManager.class);

	@Override
	public boolean validateUser(User user) throws ApplicationException {
		if(user.getUserName()==""||user.getPassword()==""||user.getConfirmPassword()=="")
		{
			logger.info("User didnot entered all the fields");
			throw new ApplicationException("All fields are mandatory");
		}
		else if(user.getUserName().length()<6 || user.getUserName().length()>25)
		{
			logger.info("User entered the length less than 6 or greater than 25");
			throw new ApplicationException("Username length should be in between 6-25");
		}
		else if(!(user.getPassword().equals(user.getConfirmPassword())))
		{
			logger.info("User Password and Confirm Password are not same");
			throw new ApplicationException("Passwords are not same");
		}
		else if(isPasswordNotStrong(user.getPassword()))
		{
			logger.info("User Password is not strong");
			throw new ApplicationException("Password is not strong");
		}
		else
		{
			return true;
		}
		
	}

	@Override
	public boolean isPasswordNotStrong(String password) throws ApplicationException {
		
		if(password.length()<8)
		{
			return true;
		}
		else
		{
			int captialLetterCount=0;
			int smallLetterCount=0;
			int numberCount=0;
			int specialCharacterCount=0;
			
			for(int i=0;i<password.length();i++)
			{
				if(password.charAt(i)>='A' && password.charAt(i)<='Z')
				{
					captialLetterCount++;
				}
				else if(password.charAt(i)>='a' && password.charAt(i)<='z')
				{
					smallLetterCount++;
				}
				else if(password.charAt(i)>='0' && password.charAt(i)<='9')
				{
					numberCount++;
				}
				else if(password.charAt(i)=='!'||password.charAt(i)=='@'||password.charAt(i)=='#'||password.charAt(i)=='$'||
						password.charAt(i)=='%'||password.charAt(i)=='&'||password.charAt(i)=='*')
				{
					specialCharacterCount++;
				}
			}
			
			if(captialLetterCount< 1 || smallLetterCount< 1|| numberCount<1 || specialCharacterCount< 1 )
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	}

}
