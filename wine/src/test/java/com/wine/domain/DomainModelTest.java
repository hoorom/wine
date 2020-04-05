package com.wine.domain;

import org.junit.jupiter.api.Test;

import com.wine.bottle.domain.Bottle;

class DomainModelTests {

	private Bottle bottle;


	@Test
	void buildNewItemTest()  {
		bottle = new Bottle();
		bottle.setName("beaujolais");
		
	}

}