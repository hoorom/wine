package com.wine.auth.form;

import org.springframework.validation.Errors;

import com.wine.auth.factory.UserFactory;
import com.wine.auth.model.User;
import com.wine.frmwrk.factory.AbstractFactory;
import com.wine.frmwrk.form.WineCreationForm;

import lombok.Getter;
import lombok.Setter;

public class UserForm implements WineCreationForm<User> {
	
	@Getter @Setter
	private String username;
	
	@Getter @Setter
	private String password;

	@Getter
	@Setter
	private String confirmPassword;

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object o, Errors errors) {
		// TODO Auto-generated method stub
	}

	@Override
	public User createObject() {
		User user = getFactory().createObject(this);
		return user;
	}

	@Override
	public AbstractFactory<User> getFactory() {
		return new UserFactory();
	}
	
}
