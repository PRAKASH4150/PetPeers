package com.hcl.pp.validation;

import org.springframework.stereotype.Service;

import com.hcl.pp.appexception.ApplicationException;
import com.hcl.pp.model.Pet;

@Service("petValidatorImpl")
public class PetValidatorImpl implements PetValidator {

	@Override
	public void validatePet(Pet pet) throws ApplicationException {
		
		if(pet.getName()==""||pet.getPlace()=="")
		{
			throw new ApplicationException("All Fields are Mandatory");
		}
		else if(pet.getAge()<0 || pet.getAge()>99)
		{
			throw new ApplicationException("Age should be in between 0-99");
		}
	}
}
