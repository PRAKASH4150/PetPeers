package com.hcl.pp.validation;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.hcl.pp.appexception.ApplicationException;
import com.hcl.pp.model.Pet;
/**
 * 
 * @author KanumuriSaketh(51897445)
 *
 */
@Service("petValidatorImpl")
public class PetValidatorImpl implements PetValidator {

	private static final Logger logger=LogManager.getLogger(PetValidatorImpl.class);
			
	@Override
	public void validatePet(Pet pet) throws ApplicationException {
		
		if(pet.getName()==""||pet.getPlace()=="")
		{
			logger.info("User didnot entered all the details");
			throw new ApplicationException("All Fields are Mandatory");
		}
		else if(pet.getAge()<0 || pet.getAge()>99)
		{
			logger.info("User didnt entered age between 0-99");
			throw new ApplicationException("Age should be in between 0-99");
		}
	}
}
