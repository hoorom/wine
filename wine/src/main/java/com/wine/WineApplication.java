package com.wine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wine.domain.Bottle;
import com.wine.form.BottleForm;
import com.wine.service.BottleService;

@SpringBootApplication
@Controller
public class WineApplication {

	@Autowired
	BottleService bottleService;

	@RequestMapping("/index")
	String index() {
		return "index";
	}

	@RequestMapping(value = { "/bottleList" }, method = RequestMethod.GET)
	public String bottleList(Model model) {
		model.addAttribute("bottles", bottleService.getBottles());
		return "bottleList";
	}

	@RequestMapping(value = { "/addBottle" }, method = RequestMethod.GET)
	public String showAddBottle(Model model) {
		BottleForm bottleForm = new BottleForm();
		model.addAttribute("bottleForm", bottleForm);

		return "addBottle";
	}

	@RequestMapping(value = { "/addBottle" }, method = RequestMethod.POST)
	public String addBottle(Model model, //
			@ModelAttribute("bottleForm") BottleForm bottleForm) {

		String name = bottleForm.getName();
		
		Bottle bottle = new Bottle();
		bottle.setName(name);
		
		bottleService.createBottle(bottle);

		return "redirect:/bottleList";
	}

	public static void main(String[] args) {
		SpringApplication.run(WineApplication.class, args);
	}

}
