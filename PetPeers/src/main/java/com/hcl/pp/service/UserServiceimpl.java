package com.hcl.pp.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.pp.appexception.ApplicationException;
import com.hcl.pp.dao.UserDao;
import com.hcl.pp.model.Pet;
import com.hcl.pp.model.User;
/**
 * 
 * @author MokaSaiSuryaPrakash(51897451)
 *
 */

@Service("userServiceImpl")
public class UserServiceimpl implements UserService {

	@Autowired
	private UserDao userDaoImpl;
	
	private static final Logger logger= LogManager.getLogger(UserServiceimpl.class);
	
	@Override
	@Transactional
	public void doesUserExists(User user) throws ApplicationException {
		
		logger.info(user.getUserName()+" entered in to doesUserExists Method of Service layer");
		userDaoImpl.doesUserExists(user);
		
	}

	@Override
	@Transactional
	public void addUser(User user) {
		
		logger.info(user.getUserName()+" entered in to addUser Method of Service layer");
		userDaoImpl.addUser(user);
		
	}

	@Override
	@Transactional
	public void buyPet(long petId, User user) {
	
		logger.info(user.getUserName()+" entered in to buyPet Method of Service layer");
		userDaoImpl.buyPet(petId, user);
		
	}

	@Override
	@Transactional
	public List<Pet> getMyPets(User user) {
		logger.info(user.getUserName()+" entered in to getMyPets Method of Service layer");
		return (userDaoImpl.getMyPets(user));
	}
	
}
