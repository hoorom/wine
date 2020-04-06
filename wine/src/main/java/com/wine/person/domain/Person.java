package com.wine.person.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.wine.bottle.domain.Cellar;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@ToString
@EqualsAndHashCode
/**
 * Utilisateur
 */
public class Person {

	@Id
	@GeneratedValue
	private Long id;

	private String firstName;

	private String lastName;

	@OneToMany(mappedBy = "person")
	private List<Cellar> cellars;

}
