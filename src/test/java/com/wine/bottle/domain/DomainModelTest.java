package com.wine.bottle.domain;

import org.junit.jupiter.api.Test;

class DomainModelTests {

	private Bottle bottle;


	@Test
	void buildNewItemTest()  {
		bottle = new Bottle();
		bottle.setName("beaujolais");
		
	}

}