package com.hcl.pp.validation;

import com.hcl.pp.appexception.ApplicationException;
import com.hcl.pp.model.Pet;

public interface PetValidator {
	
	public void validatePet(Pet pet) throws ApplicationException;
}
