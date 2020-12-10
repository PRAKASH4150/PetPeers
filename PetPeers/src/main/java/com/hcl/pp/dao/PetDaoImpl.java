package com.hcl.pp.dao;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.hcl.pp.model.Pet;
/**
 * 
 * @authors GummadiSunilKumar(51897413),KanumuriSaketh(51897445)
 *
 */
@Repository("petDaoImpl")
public class PetDaoImpl implements PetDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private static final Logger logger=LogManager.getLogger(PetDaoImpl.class);
	
	@Override
	public List<Pet> getAllPets() {

        String sql="SELECT * FROM PETS";//Native Query returns a Result Set
		Session session = sessionFactory.getCurrentSession();
		List<Pet> petList=session.createNativeQuery(sql).addEntity(Pet.class).list();
		logger.info("User entered in to getAllPets method of PetDaoImpl in Dao layer");
		return petList;
	}

	@Override
	public void savePet(Pet pet) {
	
		Session session=sessionFactory.getCurrentSession();
		logger.info("User entered in to savePet method of PetDaoImpl in Dao layer");
		session.save(pet);
	}

}
