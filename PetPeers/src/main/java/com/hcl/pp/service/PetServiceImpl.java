package com.hcl.pp.service;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hcl.pp.dao.PetDao;
import com.hcl.pp.model.Pet;
/**
 * 
 * @authors GummadiSunilKumar(51897413),KanumuriSaketh(51897445)
 *
 */
@Service("petServiceImpl")
public class PetServiceImpl implements PetService {

	@Autowired
	private PetDao petDaoImpl;
	
	private static final Logger logger=LogManager.getLogger(PetServiceImpl.class);
	
	@Override
	@Transactional
	public List<Pet> getAllPets() {
		logger.info("User entered in  to getAllPets method of PetServiceImpl in Service layer");
		return petDaoImpl.getAllPets();
	}

	@Override
	@Transactional
	public void savePet(Pet pet) {
		logger.info("User entered in to savePet method of PetServiceImp in service layer" );
		petDaoImpl.savePet(pet);
	}

}
