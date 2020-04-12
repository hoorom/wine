package com.wine.bottle.service;

import java.util.Collection;

import com.wine.bottle.domain.Bottle;

public interface BottleService {

	/**
	 * Cr�er une bouteille
	 */
	public abstract void createBottle(Bottle bottle);

	/**
	 * Mise � jour
	 */
	public abstract void updateBottle(Long id, Bottle bottle);

	/**
	 * Suppression
	 */
	public abstract void deleteBottle(Long id);

	/**
	 * Liste des bouteilles
	 */
	public abstract Collection<Bottle> getBottles();

	/**
	 * Liste des bouteilles remplies
	 */
	public abstract Collection<Bottle> getFullBottles();
}
