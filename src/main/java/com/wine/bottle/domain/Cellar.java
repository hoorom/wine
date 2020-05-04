package com.wine.bottle.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.wine.bottle.util.CellarType;
import com.wine.person.domain.Person;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity	
@ToString
@EqualsAndHashCode
/**
 * Cave
 */
public class Cellar {

	@Id
    @GeneratedValue
	private Long id;

	/**
	 * Nom
	 */
	@Getter
	@Setter
	private String name;
	
	/**
	 * Bouteilles rangees dedans
	 */
	@OneToMany(mappedBy="cellar")
	@Getter
	@Setter
	private List<Bottle> bottles;

	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "person_id")
	private Person person;

	/**
	 * Type de cave
	 */
	@Getter
	@Setter
	private CellarType type;

}
