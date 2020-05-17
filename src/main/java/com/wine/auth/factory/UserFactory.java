package com.wine.auth.factory;

import com.wine.auth.domain.User;
import com.wine.auth.form.UserForm;
import com.wine.frmwrk.factory.AbstractFactory;
import com.wine.frmwrk.form.WineCreationForm;
import com.wine.person.domain.Person;
import com.wine.person.factory.PersonFactory;

/**
 * Factory des utilisateurs
 */
public class UserFactory extends AbstractFactory<User> {

	@Override
	public User createObject(WineCreationForm<User> wineCreationForm) {
		UserForm userForm = (UserForm) wineCreationForm;
		User user = new User();
		user.setUsername(userForm.getUsername());
		user.setPassword(userForm.getPassword());

		Person person = createUserPerson(userForm);
		user.setPerson(person);

		return user;
	}

	/**
	 * Creation de la personne associee a l utilisateur
	 */
	private Person createUserPerson(UserForm userForm) {
		PersonFactory personFactory = new PersonFactory();
		Person person = personFactory.createObject();
		person.setCivility(userForm.getCivility());
		person.setFirstName(userForm.getFirstName());
		person.setLastName(userForm.getLastName());
		person.setBirthdate(userForm.getBirthdate());
		return person;
	}

	@Override
	public User createObject() {
		User user = new User();
		return user;
	}

}
