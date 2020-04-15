package com.wine.bottle.form;

import com.wine.bottle.util.BottleSize;
import com.wine.bottle.util.WineColor;
import com.wine.bottle.util.WineLabel;

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
	
	@Getter
	@Setter
	private Integer vintage;

	@Getter
	@Setter
	private Integer quantity;

	@Getter
	@Setter
	private WineLabel label;

	@Getter
	@Setter
	private WineColor color;

	@Getter
	@Setter
	private String domain;

	@Getter
	@Setter
	private Integer drinkFrom;

	@Getter
	@Setter
	private Integer drinkTo;

	@Getter
	@Setter
	private Double price;
}
