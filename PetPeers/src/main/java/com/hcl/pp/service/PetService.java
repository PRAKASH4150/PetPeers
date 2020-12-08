package com.hcl.pp.service;
import java.util.List;
import com.hcl.pp.model.Pet;
import com.hcl.pp.model.User;

public interface PetService {

	public List<Pet> getAllPets();
	
	public void savePet(Pet pet);
	
}
