package com.wine.person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.wine.person.service.PersonService;

import lombok.extern.slf4j.Slf4j;

/**
 * Controller du profile
 */
@Controller
@Slf4j
public class PersonController {

	@Autowired
	private PersonService personService;

	/**
	 * Personne connectees
	 */
	@GetMapping(value = { "/profile" })
	public String currentUserName(Model model) {
		model.addAttribute("person", personService.getConnectedPerson());
		return "profile";
	}

}
