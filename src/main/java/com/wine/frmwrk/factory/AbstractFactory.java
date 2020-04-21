package com.wine.frmwrk.factory;

import com.wine.frmwrk.form.WineCreationForm;

/**
 * Factory abstraite de creation d objets metiers
 */
public abstract class AbstractFactory<T> {

	public abstract T createObject(WineCreationForm<T> creationForm);
}
