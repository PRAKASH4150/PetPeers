package com.hcl.pp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hcl.pp.appexception.ApplicationException;
import com.hcl.pp.model.Pet;
import com.hcl.pp.model.User;
import com.hcl.pp.service.PetService;
import com.hcl.pp.service.UserService;
import com.hcl.pp.validation.PetValidator;

@Controller
public class PetController {

	@Autowired
	private PetService petServiceImpl;
	
	@Autowired
	private PetValidator petValidatorImpl;
	
	@Autowired
	private UserService userServiceImpl;
	
	@RequestMapping("pets")
	public String petHome(Model model)
	{
		List<Pet>petsList=petServiceImpl.getAllPets();
		model.addAttribute("pets",petsList);
		return "pet_home";
	}
	
	@RequestMapping("petfront")
	public String addPetFront(Model model)
	{
		model.addAttribute("petDetails",new Pet());
		return "pet_form";
	}
	
	@PostMapping("addPet")
	public String addPet(@ModelAttribute("petDetails") Pet petdetails, Model model)
	{
		try {
			petValidatorImpl.validatePet(petdetails);
			petServiceImpl.savePet(petdetails);
			return "redirect:/pets";
		} catch (ApplicationException e) {
		     model.addAttribute("error",e.getMessage());
		     return"pet_form";
		}
	
	}
	
	@RequestMapping("buyPet/{petId}")
	public String buyPet(@PathVariable("petId")long petId,HttpServletRequest request)
	{
		User user=(User)request.getSession().getAttribute("user");
		userServiceImpl.buyPet(petId,user);
		return"redirect:/pets";
	}
	
	@RequestMapping("mypets")
	public String myPets(HttpServletRequest request,Model model)
	{
		User user=(User)request.getSession().getAttribute("user");
		List<Pet>myPets=userServiceImpl.getMyPets(user);
		model.addAttribute("myPets",myPets);
		return "my_pets";
		
	}
	
	
}
