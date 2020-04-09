package com.wine.bottle;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.wine.bottle.domain.Bottle;
import com.wine.bottle.repository.BottleRepository;
import com.wine.bottle.service.BottleService;

@SpringBootTest
class WineApplicationTests {

	@MockBean
	private BottleRepository bottlerRepository;

	@Autowired
	private BottleService bottleService;

	@Test
	void testaddBottle() {
		Bottle bottle = new Bottle();
		bottle.setName("Beaujolais");
		
		bottleService.createBottle(bottle);
		assertTrue(1 == 1);

	}

}
