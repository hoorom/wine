package com.wine.bottle.factory;

import com.wine.bottle.domain.Cellar;
import com.wine.frmwrk.factory.AbstractFactory;
import com.wine.frmwrk.form.WineCreationForm;

public class CellarFactory extends AbstractFactory<Cellar> {

	@Override
	public Cellar createObject() {
		Cellar cellar = Cellar.builder().build();
		return cellar;
	}

	@Override
	public Cellar createObject(WineCreationForm<Cellar> creationForm) {
		// TODO Auto-generated method stub
		return null;
	}

}
