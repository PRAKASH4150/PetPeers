package com.hcl.pp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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
/**
 * 
 * @authors GummadiSunilKumar(51897413),KanumuriSaketh(51897445)
 *
 */
@Controller
public class PetController {

	@Autowired
	private PetService petServiceImpl;

	@Autowired
	private PetValidator petValidatorImpl;

	@Autowired
	private UserService userServiceImpl;

	private static final Logger logger = LogManager.getLogger(PetController.class);

	@RequestMapping("pets")
	public String petHome(Model model, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			List<Pet> petsList = petServiceImpl.getAllPets();
			logger.info("User entered in to petHome method of PetController class");
			if (petsList.size() > 0) {
				logger.info("Pets List is succesfuly displayed on the pet home screeen");
				model.addAttribute("pets", petsList);
				return "pet_home";
			} else {
				model.addAttribute("message", "There are no pets to show");
				logger.info("There are no pets to show on the home poage screen");
				return "pet_home";
			}
		} else {
			return "redirect:user/login";
		}

	}

	@RequestMapping("petfront")
	public String addPetFront(Model model, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			logger.info("User entered in to addPetFront method if PetController");
			model.addAttribute("petDetails", new Pet());
			return "pet_form";
		} else {
			return "redirect:user/login";
		}

	}

	@PostMapping("addPet")
	public String addPet(@ModelAttribute("petDetails") Pet petdetails, Model model, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");

		if (user != null) {
			try {
				petValidatorImpl.validatePet(petdetails);
				petServiceImpl.savePet(petdetails);
				logger.info("User entered in to addPet method if PetController");
				return "redirect:/pets";
			} catch (ApplicationException e) {
				model.addAttribute("error", e.getMessage());
				return "pet_form";
			}
		} else {
			return "redirect:user/login";
		}

	}

	@RequestMapping("buyPet/{petId}")
	public String buyPet(@PathVariable("petId") long petId, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");

		if (user != null) {
			userServiceImpl.buyPet(petId, user);
			logger.info(user.getUserName() + " entered in to buyPet method of PetController");
			return "redirect:/pets";
		} else {
			return "redirect:user/login";
		}
	}

	@RequestMapping("mypets")
	public String myPets(HttpServletRequest request, Model model) {
		User user = (User) request.getSession().getAttribute("user");

		if (user != null) {
			List<Pet> myPets = userServiceImpl.getMyPets(user);
			logger.info(user.getUserName() + " entered in to myPets method of PetController");
			if (myPets.size() > 0) {
				model.addAttribute("myPets", myPets);
				logger.info(
						"Pets belong to " + user.getUserName() + "are displayed successfully on the my_pets.jsp page");
				return "my_pets";
			} else {
				logger.info("There are no owned pets by " + user.getUserName());
				model.addAttribute("message", "You donot own any pets");
				return "my_pets";
			}
		} else {
			return "redirect:user/login";
		}

	}

}
