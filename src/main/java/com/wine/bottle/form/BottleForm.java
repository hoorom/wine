package com.wine.bottle.form;

import com.wine.bottle.util.BottleSize;

import lombok.Getter;
import lombok.Setter;

public class BottleForm {

	@Getter
	@Setter
	private String name;
	
	
	@Getter
	@Setter
	private BottleSize size;
	
}
