package com.wine.service;

import java.util.Collection;

import com.wine.domain.Bottle;

public interface BottleService {

	public abstract void createBottle(Bottle bottle);
	public abstract void updateBottle(Long id, Bottle bottle);
	public abstract void deleteBottle(Long id);
	public abstract Collection<Bottle> getBottles();
}
