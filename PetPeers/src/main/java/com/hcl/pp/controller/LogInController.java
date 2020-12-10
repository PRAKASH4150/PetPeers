package com.hcl.pp.controller;

import javax.servlet.http.HttpServletRequest;

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
import com.hcl.pp.service.LoginService;
import com.hcl.pp.validation.LoginValidator;
/**
 * 
 * @author LakamsaniHanumanSai(51897508)
 *
 */

@Controller
@RequestMapping("user")
public class LogInController {
	
	@Autowired
	private LoginValidator loginValidatorImpl;
   
	@Autowired
	private LoginService loginServiceImpl;
	
	private static final Logger logger= LogManager.getLogger(LogInController.class);
	
	@RequestMapping("login")
	public String LoginUserFront(Model model)
	{
		System.out.println("hello world2");
		model.addAttribute("logInDetails",new User());
		return "login";
	}
	@PostMapping("authenticate")
	public String authenticateUser(@ModelAttribute("logInDetails") User user,Model model,HttpServletRequest request)
	{
		logger.info(user.getUserName()+" entered in to authenticateUser method of LogInController");
		try {
			loginValidatorImpl.validateUserLogin(user);
			User userObj=loginServiceImpl.validateUser(user);
			request.getSession().setAttribute("user",userObj);
			logger.info("User "+userObj.getUserName()+" is logged in successfully");
			return "redirect:/pets";
		    } catch (ApplicationException e) {
			model.addAttribute("error",e.getMessage());		
			return "login";
			}
		
	}
}
