package com.hcl.pp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.pp.model.Pet;
import com.hcl.pp.model.User;
@Repository("petDaoImpl")
public class PetDaoImpl implements PetDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Pet> getAllPets() {

        String sql="SELECT * FROM PETS";//Native Query returns a Result Set
		Session session = sessionFactory.getCurrentSession();
		List<Pet> petList=session.createNativeQuery(sql).addEntity(Pet.class).list();
		return petList;
	}

	@Override
	public void savePet(Pet pet) {
	
		Session session=sessionFactory.getCurrentSession();
		session.save(pet);
	}

}
