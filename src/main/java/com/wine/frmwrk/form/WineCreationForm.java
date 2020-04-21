package com.wine.frmwrk.form;

import com.wine.frmwrk.factory.AbstractFactory;

public interface WineCreationForm<T> extends WineForm {

	public T createObject();

	public AbstractFactory<T> getFactory();
}
