package com.iris.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iris.entity.Specialization;
import com.iris.service.SpecializationService;

@Controller
@RequestMapping("/spec")
public class SpecializationController {

	@Autowired
	private SpecializationService service;

	/**
	 * 1. display all Specialization
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/all")
	public String viewAllSpecialization(Model model) {
		List<Specialization> allSpecialization = service.getAllSpecialization();
		System.out.println("Printing allSpecialization: "+allSpecialization);
		model.addAttribute("allSpecialization", allSpecialization);
		return "specialization-data";
	}

}
