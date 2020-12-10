package com.hcl.pp.controller;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hcl.pp.appexception.ApplicationException;
import com.hcl.pp.model.User;
import com.hcl.pp.service.UserService;
import com.hcl.pp.validation.SecurityService;
/**
 * 
 * @author MokaSaiSuryaPrakash(51897451)
 *
 */
@Controller
@RequestMapping("user")
public class RegistrationController {
	
	@Autowired
	private SecurityService securityServiceImpl;
	
	@Autowired
	private UserService userServiceImpl;
    
	private static final Logger logger= LogManager.getLogger(RegistrationController.class);
	
	
	@RequestMapping("front")
	public String addUserFront(Model model)
	{
		System.out.println("hello world");
		model.addAttribute("userDetails",new User());
		return "userregn";
	}
	
	@PostMapping("add")
	public String addUser(@ModelAttribute("userDetails") User user,Model model)
	{
		try {
			securityServiceImpl.validateUser(user);	
			userServiceImpl.doesUserExists(user);
			userServiceImpl.addUser(user);
			logger.info(user.getUserName()+" entered into addUser method of RegistrationController");
			logger.info("User "+user.getUserName()+" has been registered");
			return "registered";
			
		} catch (ApplicationException e) {
			model.addAttribute("error",e.getMessage());
			return "userregn";
		}
	}

}
