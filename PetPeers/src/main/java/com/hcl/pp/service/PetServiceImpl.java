package com.hcl.pp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.pp.dao.PetDao;
import com.hcl.pp.model.Pet;

@Service("petServiceImpl")
public class PetServiceImpl implements PetService {

	@Autowired
	private PetDao petDaoImpl;
	
	@Override
	@Transactional
	public List<Pet> getAllPets() {
		return petDaoImpl.getAllPets();
	}

	@Override
	@Transactional
	public void savePet(Pet pet) {
		petDaoImpl.savePet(pet);
	}

}
