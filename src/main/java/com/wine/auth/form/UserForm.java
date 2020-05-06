package com.wine.auth.form;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.wine.auth.domain.User;
import com.wine.auth.factory.UserFactory;
import com.wine.auth.service.UserService;
import com.wine.frmwrk.factory.AbstractFactory;
import com.wine.frmwrk.form.WineCreationForm;

import lombok.Getter;
import lombok.Setter;

@Component
public class UserForm implements WineCreationForm<User> {
	
	@Qualifier("userServiceImpl")
	@Autowired
	private UserService userService;

	@Getter @Setter
	private String username;
	
	@Getter @Setter
	private String firstName;

	@Getter
	@Setter
	private String lastName;

	@Getter
	@Setter
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthdate;

	@Getter
	@Setter
	private String password;

	@Getter
	@Setter
	private String passwordConfirm;

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
