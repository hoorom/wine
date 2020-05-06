package com.wine.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wine.person.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
