package com.hcl.pp.dao;

import java.util.List;
import com.hcl.pp.model.Pet;
import com.hcl.pp.model.User;

public interface PetDao {

	public List<Pet> getAllPets();
	
	public void savePet(Pet pet);
}
