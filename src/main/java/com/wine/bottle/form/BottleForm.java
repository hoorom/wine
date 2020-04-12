package com.wine.bottle.form;

import com.wine.bottle.util.BottleSize;

import lombok.Getter;
import lombok.Setter;

/**
 * Forme relatif aux bouteilles
 */
public class BottleForm {

	@Getter
	@Setter
	private String name;
	
	
	@Getter
	@Setter
	private BottleSize size;
	
}
