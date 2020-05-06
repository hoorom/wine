package com.wine.person.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.wine.auth.domain.User;
import com.wine.auth.repository.UserRepository;
import com.wine.person.domain.Person;
import com.wine.person.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public Person getConnectedPerson() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		
		User user = userRepository.findByUsername(currentPrincipalName);
		Person person = user.getPerson();
		return person;
	}

}
