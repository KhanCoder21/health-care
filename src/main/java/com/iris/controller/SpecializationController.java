package com.iris.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iris.entity.Specialization;
import com.iris.exception.SpecializationNotFoundException;
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
	 * 2. On submit from save data
	 * 
	 * @param specialization
	 * @param model
	 * @return
	 */
	@PostMapping("/save")
	public String saveRegisterForm(@ModelAttribute Specialization specialization, Model model) {
		Long specId = service.saveSpecialization(specialization);
		String message = "Record " + specId + " is created successfully";
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
	public String viewAllSpecialization(Model model,
			@RequestParam(value = "message", required = false) String message) {
		List<Specialization> allSpecialization = service.getAllSpecialization();
		System.out.println("Printing allSpecialization: " + allSpecialization);
		model.addAttribute("allSpecialization", allSpecialization);
		model.addAttribute("message", message);
		return "specialization-data";
	}

	/**
	 * 4. delete record by id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/delete")
	public String deleteData(@RequestParam Long id, RedirectAttributes attributes) {
		try {
			service.removeSpecializationById(id);
			attributes.addAttribute("message", "Record " + id + " is removed successfully");
		} catch (SpecializationNotFoundException e) {
			e.printStackTrace();
			attributes.addAttribute("message", e.getMessage());
		}
		return "redirect:all";
	}

	/**
	 * 5 . Load data from Db and Show in Edit page
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/edit")
	public String showEditPage(@RequestParam Long id, Model model, RedirectAttributes attributes) {
		String page = null;
		try {
			Specialization spec = service.getSpecializationById(id);
			model.addAttribute("specialization", spec);
			page = "specialization-edit";
		} catch (SpecializationNotFoundException e) {
			e.printStackTrace();
			attributes.addAttribute("message", e.getMessage());
			page = "redirect:all";
		}
		return page;
	}

	/**
	 * 4. delete record by id
	 * 
	 * @param id
	 * @return
	 */
	@PostMapping("/update")
	public String updateData(@ModelAttribute Specialization specialization, RedirectAttributes attributes) {
		service.updateSpecialization(specialization);
		attributes.addAttribute("message", "Record " + specialization.getId() + " is updated successfully");
		return "redirect:all";
	}

	@GetMapping("/checkcode")
	@ResponseBody
	public String validateSpecCode(@RequestParam String code) {
		String message = "";
		if (service.isSpecCodeExist(code)) {
			message = code + ", already exist";
		}
		return message;
	}

}
