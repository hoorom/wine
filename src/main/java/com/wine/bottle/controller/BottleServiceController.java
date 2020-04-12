package com.wine.bottle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wine.bottle.domain.Bottle;
import com.wine.bottle.form.BottleForm;
import com.wine.bottle.repository.BottleRepository;
import com.wine.bottle.service.BottleService;
import com.wine.bottle.util.BottleSize;
import com.wine.bottle.util.BottleStatus;

@Controller
/**
 * Controller relatif aux actions sur les bouteilles
 */
public class BottleServiceController {

	@Autowired
	BottleService bottleService;

	@Autowired
	BottleRepository bottleRepository;

	/**
	 * Liste des bouteilles pleines
	 */
	@RequestMapping(value = { "/bottleList" }, method = RequestMethod.GET)
	public String fullBottleList(Model model) {
		model.addAttribute("fullBottles", bottleService.getFullBottles());
		return "bottleList";
	}

	/**
	 * Redirection vers la page d'ajout de bouteille
	 */
	@RequestMapping(value = { "/addBottle" }, method = RequestMethod.GET)
	public String showAddBottle(Model model) {
		BottleForm bottleForm = new BottleForm();
		model.addAttribute("bottleForm", bottleForm);

		return "addBottle";
	}

	/**
	 * Cr�ation d'une bouteille
	 */
	@RequestMapping(value = { "/bottleList/addBottle" }, method = RequestMethod.POST)
	public String addBottle(Model model, @ModelAttribute("bottleForm") BottleForm bottleForm) {

		String name = bottleForm.getName();
		BottleSize size = bottleForm.getSize();

		Bottle bottle = new Bottle();
		bottle.setName(name);
		bottle.setSize(size);
		bottle.setStatus(BottleStatus.FULL);

		bottleService.createBottle(bottle);

		return "redirect:/bottleList";
	}

	/**
	 * Boire une bouteille
	 */
	@RequestMapping(value = "/bottleList/drinkBottle/{bottleId}", method = RequestMethod.GET)
	public String drinkBottle(@PathVariable String bottleId) {
		Long id = Long.valueOf(bottleId);
		Bottle bottle = bottleRepository.getOne(id);
		bottle.setStatus(BottleStatus.EMPTY);
		bottleService.updateBottle(id, bottle);
		return "redirect:/bottleList";
	}
}
