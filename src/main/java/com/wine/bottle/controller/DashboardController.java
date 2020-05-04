package com.wine.bottle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.wine.bottle.repository.CellarRepository;
import com.wine.bottle.service.CellarService;

import lombok.extern.slf4j.Slf4j;

/**
 * Controller du dashboard
 */
@Controller
@Slf4j
public class DashboardController {

	@Autowired
	private CellarService cellarService;

	@Autowired
	private CellarRepository cellarRepository;

	/**
	 * Liste des caves
	 */
	@GetMapping(value = { "/dashboard" })
	public String fullBottleList(Model model) {
		model.addAttribute("cellars", cellarService.getCellars());
		return "dashboard";
	}

}
