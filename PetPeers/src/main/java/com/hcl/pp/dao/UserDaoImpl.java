package com.hcl.pp.dao;

import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.pp.appexception.ApplicationException;
import com.hcl.pp.model.Pet;
import com.hcl.pp.model.User;
/**
 * 
 * @author MokaSaiSuryaPrakash(51897451)
 *
 */

@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private static final Logger logger= LogManager.getLogger(UserDaoImpl.class);
	
	@Override
	public void doesUserExists(User user) throws ApplicationException {
		
		Long user_count;
		String sql="SELECT COUNT(userId)  FROM User user WHERE user.userName=:username";
		
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery(sql);
		query.setString("username",user.getUserName());
		user_count=(Long) query.uniqueResult();
		logger.info(user.getUserName()+" entered in to doesUserExists method of Dao Layer");
		logger.info("User Count of doesUserExists method :"+user_count);

		
		if(user_count==1)
		{
			logger.warn(user.getUserName()+" is already in use. Please select a different User Name");
			throw new ApplicationException("User Name already in use. Please select a different User Name");
		}
	}

	@Override
	public void addUser(User user) {
		Session session=sessionFactory.getCurrentSession();
    	session.save(user);
		logger.info(user.getUserName()+" entered in to addUser method of UserDaoImpl class");
		logger.info(user.getUserName()+" details sucessfully added in to the database");
	}

	@Override
	public void buyPet(long petId,User user) {
	 
		Session session = sessionFactory.getCurrentSession();
		Pet pet = (Pet) session.get(Pet.class,petId);
		pet.setOwner(user);
		session.update(pet);
		logger.info(user.getUserName()+" entered in to buyPet method of UserDaoImpl");
		logger.info(user.getUserName()+" bought a pet named "+pet.getName());
	}

	@Override
	public List<Pet> getMyPets(User user) {
      
		  String sql="SELECT * FROM PETS WHERE OWNER_ID="+user.getUserId();//Native Query returns a Result Set
		  Session session = sessionFactory.getCurrentSession();
		  List<Pet> myPetList=session.createNativeQuery(sql).addEntity(Pet.class).list();
		  logger.info(user.getUserName()+" entered in to getMyPets method of UserDaoImpl");
		  logger.info("Pets List is returned successfully!!");
			return myPetList;


	}
}
