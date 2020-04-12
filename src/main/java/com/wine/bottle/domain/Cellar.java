package com.wine.bottle.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.EqualsAndHashCode;
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
	private String name;
	
	/**
	 * Bouteilles rangées dedans
	 */
	@OneToMany(mappedBy="cellar")
	private List<Bottle> bottles;

}
