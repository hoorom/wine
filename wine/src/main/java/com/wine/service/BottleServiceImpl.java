package com.wine.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.wine.domain.Bottle;

@Service
public class BottleServiceImpl implements BottleService {

	private static Map<Long, Bottle> productRepo = new HashMap<>();
	static {
		Bottle chardonnay = new Bottle();
		chardonnay.setId(1l);
		chardonnay.setName("Chardonnay");
		productRepo.put(chardonnay.getId(), chardonnay);

		Bottle bandol = new Bottle();
		bandol.setId(2l);
		bandol.setName("Bandol");
		productRepo.put(bandol.getId(), bandol);
	}

	@Override
	public void createBottle(Bottle bottle) {
		productRepo.put(bottle.getId(), bottle);
	}

	@Override
	public void updateBottle(Long id, Bottle bottle) {
		productRepo.remove(id);
		bottle.setId(id);
		productRepo.put(id, bottle);

	}

	@Override
	public void deleteBottle(Long id) {
		productRepo.remove(id);
	}

	@Override
	public Collection<Bottle> getBottles() {
		return productRepo.values();
	}

}
