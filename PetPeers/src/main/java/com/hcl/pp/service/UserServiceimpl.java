package com.hcl.pp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.pp.appexception.ApplicationException;
import com.hcl.pp.dao.UserDao;
import com.hcl.pp.model.Pet;
import com.hcl.pp.model.User;

@Service("userServiceImpl")
public class UserServiceimpl implements UserService {

	@Autowired
	private UserDao userDaoImpl;
	
	@Override
	@Transactional
	public void doesUserExists(User user) throws ApplicationException {
		
		userDaoImpl.doesUserExists(user);
	}

	@Override
	@Transactional
	public void addUser(User user) {
		userDaoImpl.addUser(user);
	}

	@Override
	@Transactional
	public void buyPet(long petId, User user) {
	
		userDaoImpl.buyPet(petId, user);
	}

	@Override
	@Transactional
	public List<Pet> getMyPets(User user) {
		return (userDaoImpl.getMyPets(user));
	}
	
}
