package com.hcl.pp.service;

import java.util.List;

import com.hcl.pp.appexception.ApplicationException;
import com.hcl.pp.model.Pet;
import com.hcl.pp.model.User;
/**
 * 
 * @author MokaSaiSuryaPrakash(51897451)
 *
 */

public interface UserService {
  
	public void doesUserExists(User user) throws ApplicationException;
	public void addUser(User user);
	public void buyPet(long petId,User user);
	public List<Pet> getMyPets(User user);
}