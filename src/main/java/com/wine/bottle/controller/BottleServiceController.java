package com.wine.bottle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wine.bottle.domain.Bottle;
import com.wine.bottle.service.BottleService;

@RestController
public class BottleServiceController {

	@Autowired
	BottleService bottleService;

	@RequestMapping(value = "/bottles")
	public ResponseEntity<Object> getBottles() {
		return new ResponseEntity<>(bottleService.getBottles(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/bottles/{id}")
	public ResponseEntity<Object> getBottle(@PathVariable("id") Long id) {
		return new ResponseEntity<>(bottleService.getBottles().stream().filter(bottle -> bottle.getId() == id), HttpStatus.OK);
	}

	@RequestMapping(value = "/bottles/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateBottle(@PathVariable("id") Long id, @RequestBody Bottle bottle) {
		bottleService.updateBottle(id, bottle);
		return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/bottles/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteBottle(@PathVariable("id") Long id) {
		bottleService.deleteBottle(id); 
		return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/bottles", method = RequestMethod.POST)
	public ResponseEntity<Object> createBottle(@RequestBody Bottle bottle) {
		bottleService.createBottle(bottle);
		return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
	}
}
