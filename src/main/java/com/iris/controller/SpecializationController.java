package com.iris.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iris.entity.Specialization;
import com.iris.service.SpecializationService;

@Controller
@RequestMapping("/spec")
public class SpecializationController {

	@Autowired
	private SpecializationService service;

	/**
	 * 1. show register page
	 */
	@GetMapping("/register")
	public String displayRegister() {
		return "specialization-register";
	}

	/**
	 *  2. On submit from save data
	 * @param specialization
	 * @param model
	 * @return
	 */
	@PostMapping("/save")
	public String saveRegisterForm(@ModelAttribute Specialization specialization, Model model) {
		Long specId = service.saveSpecialization(specialization);
		String message= "Record "+specId+" is created successfully";
		model.addAttribute("message", message);
		return "specialization-register";
	}

	/**
	 * 3. display all SpeciaSpecializationlization
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/all")
	public String viewAllSpecialization(Model model) {
		List<Specialization> allSpecialization = service.getAllSpecialization();
		System.out.println("Printing allSpecialization: " + allSpecialization);
		model.addAttribute("allSpecialization", allSpecialization);
		return "specialization-data";
	}

}
