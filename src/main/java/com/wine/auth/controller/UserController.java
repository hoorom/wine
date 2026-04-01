package com.wine.auth.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

import com.wine.auth.domain.User;
import com.wine.auth.form.UserForm;
import com.wine.auth.form.UserValidator;
import com.wine.auth.service.SecurityService;
import com.wine.auth.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserValidator userValidator;

	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("userForm", new UserForm());

		return "registration";
	}

	@PostMapping("/registration")
	public String registration(@ModelAttribute("userForm") UserForm userForm, BindingResult bindingResult, Model model) {
		userValidator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			Map<String, String> fieldErrors = new HashMap<>();
			bindingResult.getFieldErrors().forEach(e -> fieldErrors.put(e.getField(), e.getDefaultMessage()));
			model.addAttribute("fieldErrors", fieldErrors);

			Map<String, String> formValues = new HashMap<>();
			formValues.put("username", userForm.getMail() != null ? userForm.getMail() : "");
			formValues.put("firstName", userForm.getFirstName() != null ? userForm.getFirstName() : "");
			formValues.put("lastName", userForm.getLastName() != null ? userForm.getLastName() : "");
			formValues.put("civility", userForm.getCivility() != null ? userForm.getCivility().name() : "");
			formValues.put("birthdate", userForm.getBirthdate() != null ? userForm.getBirthdate().toString() : "");
			model.addAttribute("formValues", formValues);

			return "registration";
		}

		User user = userForm.createObject();
		userService.save(user);

		securityService.autoLogin(user.getUsername(), user.getPassword());

		return "redirect:/login";
	}

	@GetMapping("/login")
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "login";
	}

	@GetMapping(value = "/logout")
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}

}
