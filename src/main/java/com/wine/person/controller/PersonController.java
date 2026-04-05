package com.wine.person.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.wine.frmwrk.service.MenuService;
import com.wine.person.service.PersonService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Controller du profile
 */
@Controller
@Slf4j
@RequiredArgsConstructor
public class PersonController {

	private final PersonService personService;

	private final MenuService menuService;

	/**
	 * Personne connectees
	 */
	@GetMapping(value = { "/profile" })
	public String currentUserName(Model model) {
		model.addAttribute("person", personService.getConnectedPerson());
		model.addAttribute("menuItems", menuService.getMenu());
		return "profile";
	}

}
