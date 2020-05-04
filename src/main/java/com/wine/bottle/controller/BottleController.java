package com.wine.bottle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.wine.bottle.domain.Bottle;
import com.wine.bottle.domain.Wine;
import com.wine.bottle.form.BottleForm;
import com.wine.bottle.repository.BottleRepository;
import com.wine.bottle.service.BottleService;
import com.wine.bottle.util.BottleSize;
import com.wine.bottle.util.BottleStatus;

import lombok.extern.slf4j.Slf4j;

/**
 * Controller relatif aux actions sur les bouteilles
 */
@Controller
@Slf4j
public class BottleController {

	@Autowired
	BottleService bottleService;

	@Autowired
	BottleRepository bottleRepository;

	/**
	 * Liste des bouteilles pleines
	 */
	@GetMapping(value = { "/bottleList" })
	public String fullBottleList(Model model) {
		model.addAttribute("fullBottles", bottleService.getFullBottles());
		return "bottleList";
	}

	/**
	 * Redirection vers la page d'ajout de bouteille
	 */
	@GetMapping(value = { "/bottle" })
	public String showAddBottle(Model model) {
		BottleForm bottleForm = new BottleForm();
		model.addAttribute("bottleForm", bottleForm);
		return "bottle";
	}

	/**
	 * Creation d'une bouteille
	 */
	@PostMapping(value = { "/bottleList/addBottle" })
	public String addBottle(Model model, @ModelAttribute("bottleForm") BottleForm bottleForm) {

		String name = bottleForm.getName();
		BottleSize size = bottleForm.getSize();

		Bottle bottle = new Bottle();
		bottle.setName(name);
		bottle.setSize(size);
		bottle.setStatus(BottleStatus.FULL);

		Wine wine = new Wine();
		wine.setColor(bottleForm.getColor());

		bottle.setWine(wine);

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		log.info(auth.toString());

		bottleService.createBottle(bottle);

		return "redirect:/bottleList";
	}

	/**
	 * Boire une bouteille
	 */
	@GetMapping(value = "/bottleList/drinkBottle/{bottleId}")
	public String drinkBottle(@PathVariable String bottleId) {
		Long id = Long.valueOf(bottleId);
		Bottle bottle = bottleRepository.getOne(id);
		bottle.setStatus(BottleStatus.EMPTY);
		bottleService.updateBottle(id, bottle);
		return "redirect:/bottleList";
	}
}
