package com.wine.person.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
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
	 * Prenom
	 */
	@Getter
	@Setter
	private String firstName;

	/**
	 * Nom
	 */
	@Getter
	@Setter
	private String lastName;

	/**
	 * Date de naissance
	 */
	@Getter
	@Setter
	private Date birthdate;

	/**
	 * Caves possedees
	 */
	@OneToMany(targetEntity = Cellar.class, mappedBy = "person", orphanRemoval = true, cascade = CascadeType.ALL)
	@Getter
	@Setter
	private Set<Cellar> cellars;

}
