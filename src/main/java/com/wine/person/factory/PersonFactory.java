package com.wine.person.factory;

import com.wine.bottle.domain.Cellar;
import com.wine.frmwrk.factory.AbstractFactory;
import com.wine.frmwrk.form.WineCreationForm;
import com.wine.person.domain.Person;

/**
 * Factory des personnes
 */
public class PersonFactory extends AbstractFactory<Person> {

	@Override
	public Person createObject(WineCreationForm<Person> creationForm) {
		return null;
	}

	@Override
	public Person createObject() {
		Person person = new Person();
		Cellar.builder().person(person).name("Defaut");
		return person;
	}


}
