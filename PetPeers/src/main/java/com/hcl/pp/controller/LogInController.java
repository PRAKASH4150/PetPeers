package com.hcl.pp.controller;

import javax.servlet.http.HttpServletRequest;

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

@Controller
@RequestMapping("user")
public class LogInController {
	
	@Autowired
	private LoginValidator loginValidatorImpl;
   
	@Autowired
	private LoginService loginServiceImpl;
	
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
		
		try {
			loginValidatorImpl.validateUserLogin(user);
			User userObj=loginServiceImpl.validateUser(user);
			request.getSession().setAttribute("user",userObj);
			return "redirect:/pets";
		} catch (ApplicationException e) {
			model.addAttribute("error",e.getMessage());		
			return "login";
			}
		
	}
}
