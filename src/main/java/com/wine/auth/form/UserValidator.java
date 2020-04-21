package com.wine.auth.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.wine.auth.model.User;
import com.wine.auth.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
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
			errors.rejectValue("username", "Size.userForm.username");
		}

		if (userService.findByUsername(userForm.getUsername()) != null) {
			errors.rejectValue("username", "Duplicate.userForm.username");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
		if (userForm.getPassword().length() < 8 || userForm.getPassword().length() > 32) {
			errors.rejectValue("password", "Size.userForm.password");
		}

		if (!userForm.getPassword().equals(userForm.getPasswordConfirm())) {
			errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
		}
	}

}
