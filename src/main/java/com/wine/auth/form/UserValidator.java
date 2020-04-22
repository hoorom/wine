package com.wine.auth.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.wine.auth.model.User;
import com.wine.auth.service.UserService;

@Component
public class UserValidator implements Validator {
	
	@Qualifier("userServiceImpl")
	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object o, Errors errors) {
		UserForm userForm = (UserForm) o;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
		if (userForm.getUsername().length() < 6 || userForm.getUsername().length() > 32) {
			errors.rejectValue("username", "UserForm.username.size");
		}

		if (userService.findByUsername(userForm.getUsername()) != null) {
			errors.rejectValue("username", "UserForm.username.duplicate");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
		if (userForm.getPassword().length() < 8 || userForm.getPassword().length() > 32) {
			errors.rejectValue("password", "UserForm.password.size");
		}

		if (!userForm.getPassword().equals(userForm.getPasswordConfirm())) {
			errors.rejectValue("passwordConfirm", "UserForm.passwordConfirm.diff");
		}
	}

}
