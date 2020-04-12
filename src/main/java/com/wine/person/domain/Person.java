package com.wine.person.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.wine.bottle.domain.Cellar;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Utilisateur
 */
@Entity
@ToString
@EqualsAndHashCode
public class Person {

	@Id
	@GeneratedValue
	private Long id;

	/**
	 * Prénom
	 */
	@Getter
	@Setter
	private String firstName;

	/**
	 * Nom de famille
	 */
	@Getter
	@Setter
	private String lastName;

	/**
	 * Caves possedees
	 */
	@OneToMany(mappedBy = "person")
	private List<Cellar> cellars;

}
