package com.wine.bottle.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wine.bottle.domain.Bottle;
import com.wine.bottle.repository.BottleRepository;

@Service
public class BottleServiceImpl implements BottleService {

	@Autowired
	private BottleRepository bottleRepository;

	@Override
	public void createBottle(Bottle bottle) {
		bottleRepository.save(bottle);
	}

	@Override
	public void updateBottle(Long id, Bottle bottle) {
		bottleRepository.save(bottle);
	}

	@Override
	public void deleteBottle(Long id) {
		bottleRepository.deleteById(id);
	}

	@Override
	public Collection<Bottle> getBottles() {
		List<Bottle> bottles = bottleRepository.findAll();
		return bottles;
	}

}
